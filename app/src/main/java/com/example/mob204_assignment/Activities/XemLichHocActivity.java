package com.example.mob204_assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mob204_assignment.Adapter.MonhocAdapter;
import com.example.mob204_assignment.DAO.MonhocDAO;
import com.example.mob204_assignment.Model.MonHoc;
import com.example.mob204_assignment.R;

import java.util.ArrayList;
import java.util.List;

public class XemLichHocActivity extends AppCompatActivity {
    ListView listView;
    MonhocAdapter monhocAdapter;
    List<MonHoc> monHocList;
    MonhocDAO monhocDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_lich_hoc);

        anhxa();

        khoitao();

        loadListViewLanDau();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(XemLichHocActivity.this);
                dialog.setContentView(R.layout.dialog_thongtinlichhoc);

                // anh xa
                EditText edt_mamon = dialog.findViewById(R.id.view_dialog_lichhoc_mamon);
                EditText edt_tenmon = dialog.findViewById(R.id.view_dialog_lichhoc_tenmon);
                EditText edt_ngayhoc = dialog.findViewById(R.id.view_dialog_lichhoc_ngayhoc);
                EditText edt_cahoc = dialog.findViewById(R.id.view_dialog_lichhoc_cahoc);
                EditText edt_phonghoc = dialog.findViewById(R.id.view_dialog_lichhoc_phonghoc);
                Button button_xacnhan = dialog.findViewById(R.id.button_dialog_lichhoc_xacnhan);

                edt_mamon.setText(monHocList.get(position).getMaMon());
                edt_tenmon.setText(monHocList.get(position).getTenMon());
                edt_ngayhoc.setText(monHocList.get(position).getNgayHoc());
                edt_cahoc.setText(monHocList.get(position).getCaHoc());
                edt_phonghoc.setText(monHocList.get(position).getPhongHoc());

                button_xacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    private void anhxa() {
        listView = findViewById(R.id.listview_lichhoc);
    }

    private void khoitao() {
        monhocDAO = new MonhocDAO(XemLichHocActivity.this);
        monHocList = new ArrayList<>();
        monHocList = monhocDAO.getAllData();
        monhocAdapter = new MonhocAdapter(XemLichHocActivity.this,R.layout.item_monhoc,monHocList);
    }

    private void loadListViewLanDau() {
        if (monHocList.size() == 0){
            Toast.makeText(this, "Chưa có dữ liệu", Toast.LENGTH_SHORT).show();
        }else {
            listView.setAdapter(monhocAdapter);
        }
    }


    //end
}