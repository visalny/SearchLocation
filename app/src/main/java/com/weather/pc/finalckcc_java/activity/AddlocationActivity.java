package com.weather.pc.finalckcc_java.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.weather.pc.finalckcc_java.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class AddlocationActivity extends AppCompatActivity {

    private static final String TAG = "ooo";
    @BindView(R.id.edtname_addlocation)
    EditText edtname;
    @BindView(R.id.edtemail_addlocation)
    EditText edtemail;
    @BindView(R.id.edtfacepage_addlocation)
    EditText edtfacepage;
    @BindView(R.id.edtwebsite_addlocation)
    EditText edtwebsite;
    @BindView(R.id.edtcontact_addlocation)
    EditText edtcontact;
    @BindView(R.id.edtaddress_addlocation)
    EditText edtaddress;
    @BindView(R.id.locationImage)
    ImageView locationImage;
public static final int GALLERY_IMAGE=1;
private Bitmap filepath;
private String location_name,location_email,location_address,location_website,
                location_facepage,location_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlocation);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.btnsubmit_addlocation)
    public void submit(View view) {
        String filelocation="/images/"+System.currentTimeMillis()+".png";
        final StorageReference imageRef = FirebaseStorage.getInstance().getReference(filelocation);
        //convert bitmap to byte array
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        filepath.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] bytes=stream.toByteArray();

        //start to upload
        UploadTask uploadTask=imageRef.putBytes(bytes);
        Task<Uri> urlTastk = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                return imageRef.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                String imageUrl = task.getResult().toString();
                addLocation(imageUrl);
                Log.e(TAG, "onComplete: uploaded" );
            }
        });
    }

    private void addLocation(String imageUrl){
        location_name=edtname.getText().toString();
        location_email=edtemail.getText().toString();
        location_facepage=edtfacepage.getText().toString();
        location_website=edtwebsite.getText().toString();
        location_contact=edtcontact.getText().toString();
        location_address=edtaddress.getText().toString();

        Map<String,Object> location=new HashMap<>();
        location.put("location_name",location_name);
        location.put("location_email",location_email);
        location.put("location_facepage",location_facepage);
        location.put("location_website",location_website);
        location.put("location_contact",location_contact);
        location.put("location_address",location_address);
        location.put("location_image",imageUrl);
    // upload data to firebase   //
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("locations").add(location).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful()){
                    Log.e(TAG, "onComplete: suceesfull" );
                    Toast.makeText(AddlocationActivity.this, "Upload successfull", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.e(TAG, "onComplete: Fail to upload" );
                    Toast.makeText(AddlocationActivity.this, "Upload failer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

 // browse image from gallery
    @OnClick(R.id.locationImage)
    public void browseImage(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,GALLERY_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==GALLERY_IMAGE && resultCode==RESULT_OK){
            try {
                filepath=MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                locationImage.setImageBitmap(filepath);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
