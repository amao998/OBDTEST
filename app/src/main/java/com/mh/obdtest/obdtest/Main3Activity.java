package com.mh.obdtest.obdtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private CheckBox cb_ind_resultY = null;
    private CheckBox cb_ind_resultN = null;
    private CheckBox cb_ind_commresultY = null;
    private CheckBox cb_ind_commresultN = null;
    private CheckBox cb_ind_commerr1 = null;
    private CheckBox cb_ind_commerr2 = null;
    private CheckBox cb_ind_commerr3 = null;
    private CheckBox cb_rs_nofinishitemresultY = null;
    private CheckBox cb_rs_nofinishitemresultN = null;
    private CheckBox cb_rs_nofinishitemcode1 = null;
    private CheckBox cb_rs_nofinishitemcode2 = null;
    private CheckBox cb_rs_nofinishitemcode3 = null;
    private CheckBox cb_rs_nofinishitemcode4 = null;
    private CheckBox cb_rs_nofinishitemcode5 = null;

    private TextView tv_odomil = null;
    private TextView tv_engcalid = null;
    private TextView tv_engcvn = null;
    private TextView tv_hclcalid = null;
    private TextView tv_hclcvn = null;
    private TextView tv_othercalid = null;
    private TextView tv_othercvn = null;
    private TextView tv_jyjgdesc = null;

    private CheckBox cb_indsameobd = null;
    private CheckBox cb_indislight = null;
    private CheckBox cb_jyjgY = null;
    private CheckBox cb_jyjgN = null;


    private String obdryzl = "0";

    private OBDResultDataInfo info = null;

    private Button button=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button= (Button)findViewById(R.id.but_obddata_exit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPopupWindow     popupwindow=new MyPopupWindow(Main3Activity.this, null);
                popupwindow.showAtLocation(Main3Activity.this.findViewById(R.id.but_obddata_exit), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });

        //info= new  OBDResultDataInfo();
       // InitCheck();
    }

//    private void InitCheck() {
//
//        tv_odomil = (TextView) findViewById(R.id.tv_obddata_odomil);
//        tv_odomil.setText(info.getOdomil()==null?"":info.getOdomil());
//
//        tv_engcalid = (TextView) findViewById(R.id.tv_obddata_engcalid);
//        tv_engcalid.setText(info.getEngcalid()==null?"":info.getEngcalid());
//
//        tv_engcvn = (TextView) findViewById(R.id.tv_obddata_engcvn);
//        tv_engcvn.setText(info.getEngcvn()==null?"":info.getEngcvn());
//
//        tv_hclcalid = (TextView) findViewById(R.id.tv_obddata_hclcalid);
//        tv_hclcalid.setText(info.getHclcalid()==null?"":info.getHclcalid());
//
//        tv_hclcvn = (TextView) findViewById(R.id.tv_obddata_hclcvn);
//        tv_hclcvn.setText(info.getHclcvn()==null?"":info.getHclcvn());
//
//        tv_othercalid = (TextView) findViewById(R.id.tv_obddata_othercalid);
//        tv_othercalid.setText(info.getOthercalid()==null?"":info.getOthercalid());
//
//        tv_othercvn = (TextView) findViewById(R.id.tv_obddata_othercvn);
//        tv_othercvn.setText(info.getOthercvn()==null?"":info.getOthercvn());
//
//        tv_jyjgdesc = (TextView) findViewById(R.id.tv_obddata_jyjgdesc);
//        tv_jyjgdesc.setText(info.getJyjgdesc()==null?"":info.getJyjgdesc());
//
//        cb_ind_resultY = (CheckBox) findViewById(R.id.cb_obddata_ind_resultY);
//        cb_ind_resultY.setTag(info.getInd_result() == null ? "" : info.getInd_result());
//        cb_ind_resultY.setChecked(info.getInd_result() == null ? false : info.getInd_result().equals("1"));
//        cb_ind_resultY.setOnClickListener(new MyListenerCB("1"));
//
//        cb_ind_resultN = (CheckBox) findViewById(R.id.cb_obddata_ind_resultN);
//        cb_ind_resultN.setTag(info.getInd_result() == null ? "" : info.getInd_result());
//        cb_ind_resultN.setChecked(info.getInd_result() == null ? false : info.getInd_result().equals("0"));
//        cb_ind_resultN.setOnClickListener(new MyListenerCB("0"));
//
//        cb_ind_commresultY = (CheckBox) findViewById(R.id.cb_obddata_ind_commresultY);
//        cb_ind_commresultY.setTag(info.getInd_commresult() == null ? "" : info.getInd_commresult());
//        cb_ind_commresultY.setChecked(info.getInd_commresult() == null ? false : info.getInd_commresult().equals("1"));
//        cb_ind_commresultY.setOnClickListener(new MyListenerCB("1"));
//
//        cb_ind_commresultN = (CheckBox) findViewById(R.id.cb_ind_commresultN);
//        cb_ind_commresultN.setTag(info.getInd_commresult() == null ? "" : info.getInd_commresult());
//        cb_ind_commresultN.setChecked(info.getInd_commresult() == null ? false : info.getInd_commresult().equals("0"));
//        cb_ind_commresultN.setOnClickListener(new MyListenerCB("0"));
//
//        cb_ind_commerr1 = (CheckBox) findViewById(R.id.cb_obddata_ind_commerr1);
//        cb_ind_commerr1.setTag(info.getInd_commerr() == null ? "" : info.getInd_commerr());
//        cb_ind_commerr1.setChecked(info.getInd_commerr() == null ? false : info.getInd_commerr().equals("1"));
//        cb_ind_commerr1.setOnClickListener(new MyListenerCB("1"));
//
//        cb_ind_commerr2 = (CheckBox) findViewById(R.id.cb_obddata_ind_commerr2);
//        cb_ind_commerr2.setTag(info.getInd_commerr() == null ? "" : info.getInd_commerr());
//        cb_ind_commerr2.setChecked(info.getInd_commerr() == null ? false : info.getInd_commerr().equals("2"));
//        cb_ind_commerr2.setOnClickListener(new MyListenerCB("2"));
//
//        cb_ind_commerr3 = (CheckBox) findViewById(R.id.cb_obddata_ind_commerr3);
//        cb_ind_commerr3.setTag(info.getInd_commerr() == null ? "" : info.getInd_commerr());
//        cb_ind_commerr3.setChecked(info.getInd_commerr() == null ? false : info.getInd_commerr().equals("3"));
//        cb_ind_commerr3.setOnClickListener(new MyListenerCB("3"));
//
//
//        cb_rs_nofinishitemresultY = (CheckBox) findViewById(R.id.cb_obddata_rs_nofinishitemresultY);
//        cb_rs_nofinishitemresultY.setTag(info.getRs_nofinishitemresult() == null ? "" : info.getRs_nofinishitemresult());
//        cb_rs_nofinishitemresultY.setChecked(info.getInd_commerr() == null ? false : info.getRs_nofinishitemresult().equals("1"));
//        cb_rs_nofinishitemresultY.setOnClickListener(new MyListenerCB("1"));
//
//        cb_rs_nofinishitemresultN = (CheckBox) findViewById(R.id.cb_obddata_rs_nofinishitemresultN);
//        cb_rs_nofinishitemresultN.setTag(info.getRs_nofinishitemresult() == null ? "" : info.getRs_nofinishitemresult());
//        cb_rs_nofinishitemresultN.setChecked(info.getInd_commerr() == null ? false : info.getRs_nofinishitemresult().equals("0"));
//        cb_rs_nofinishitemresultN.setOnClickListener(new MyListenerCB("0"));
//
//        cb_rs_nofinishitemcode1 = (CheckBox) findViewById(R.id.cb_obddata_rs_nofinishitemcode1);
//        cb_rs_nofinishitemcode1.setText(obdryzl.equals("0") ? "催化器" : "SCR");
//        cb_rs_nofinishitemcode1.setTag(info.getRs_nofinishitemcode() == null ? "" : info.getRs_nofinishitemcode().substring(0,1));
//        cb_rs_nofinishitemcode1.setChecked(info.getRs_nofinishitemcode() == null ? false : info.getRs_nofinishitemcode().substring(0,1).equals("1"));
//        cb_rs_nofinishitemcode1.setOnClickListener(new MyListenerCB("1"));
//
//        cb_rs_nofinishitemcode2 = (CheckBox) findViewById(R.id.cb_obddata_rs_nofinishitemcode2);
//        cb_rs_nofinishitemcode2.setText(obdryzl.equals("0") ? "氧传感器" : "POC");
//        cb_rs_nofinishitemcode2.setTag(info.getRs_nofinishitemcode() == null ? "" : info.getRs_nofinishitemcode().substring(1,1));
//        cb_rs_nofinishitemcode2.setChecked(info.getRs_nofinishitemcode() == null ? false : info.getRs_nofinishitemcode().substring(1,1).equals("1"));
//        cb_rs_nofinishitemcode2.setOnClickListener(new MyListenerCB("1"));
//
//        cb_rs_nofinishitemcode3 = (CheckBox) findViewById(R.id.cb_obddata_rs_nofinishitemcode3);
//        cb_rs_nofinishitemcode3.setText(obdryzl.equals("0") ? "氧传感器加热器" : "DOC");
//        cb_rs_nofinishitemcode3.setTag(info.getRs_nofinishitemcode() == null ? "" : info.getRs_nofinishitemcode().substring(2,1));
//        cb_rs_nofinishitemcode3.setChecked(info.getRs_nofinishitemcode() == null ? false : info.getRs_nofinishitemcode().substring(2,1).equals("1"));
//        cb_rs_nofinishitemcode3.setOnClickListener(new MyListenerCB("1"));
//
//        cb_rs_nofinishitemcode4 = (CheckBox) findViewById(R.id.cb_obddata_rs_nofinishitemcode4);
//        cb_rs_nofinishitemcode4.setText(obdryzl.equals("0") ? "EGR/VVT" : "DPF");
//        cb_rs_nofinishitemcode4.setTag(info.getRs_nofinishitemcode() == null ? "" : info.getRs_nofinishitemcode().substring(3,1));
//        cb_rs_nofinishitemcode4.setChecked(info.getRs_nofinishitemcode() == null ? false : info.getRs_nofinishitemcode().substring(3,1).equals("1"));
//        cb_rs_nofinishitemcode4.setOnClickListener(new MyListenerCB("1"));
//
//        cb_rs_nofinishitemcode5 = (CheckBox) findViewById(R.id.cb_obddata_rs_nofinishitemcode5);
//        cb_rs_nofinishitemcode5.setTag("");
//        cb_rs_nofinishitemcode5.setOnClickListener(new MyListenerCB("1"));
//        if (obdryzl.equals("0") == true) {
//            cb_rs_nofinishitemcode5.setVisibility(View.GONE);
//        } else {
//            cb_rs_nofinishitemcode5.setTag(info.getRs_nofinishitemcode() == null ? "" : info.getRs_nofinishitemcode().substring(4,1));
//            cb_rs_nofinishitemcode5.setChecked(info.getRs_nofinishitemcode() == null ? false : info.getRs_nofinishitemcode().substring(4,1).equals("1"));
//            cb_rs_nofinishitemcode5.setOnClickListener(new MyListenerCB("1"));
//            cb_rs_nofinishitemcode5.setText("EGR");
//        }
//
//        cb_indsameobd = (CheckBox) findViewById(R.id.cb_obddata_indsameobd);
//        cb_indsameobd.setTag(info.getIndsameobd()==null?"": info.getIndsameobd());
//        cb_indsameobd.setChecked(info.getIndsameobd()==null?false: info.getIndsameobd().equals("1"));
//        cb_indsameobd.setOnClickListener(new MyListenerCB("1"));
//
//        cb_indislight = (CheckBox) findViewById(R.id.cb_obddata_indislight);
//        cb_indislight.setTag(info.getIndislight()==null?"": info.getIndislight());
//        cb_indislight.setChecked(info.getIndislight()==null?false: info.getIndislight().equals("1"));
//        cb_indislight.setOnClickListener(new MyListenerCB("1"));
//
//        cb_jyjgY = (CheckBox) findViewById(R.id.cb_obddata_jyjgY);
//        cb_jyjgY.setTag(info.getJyjg()==null?"": info.getJyjg());
//        cb_jyjgY.setChecked(info.getJyjg()==null?false: info.getJyjg().equals("1"));
//        cb_jyjgY.setOnClickListener(new MyListenerCB("1"));
//
//        cb_jyjgN = (CheckBox) findViewById(R.id.cb_obddata_jyjgN);
//        cb_jyjgN.setTag(info.getJyjg()==null?"": info.getJyjg());
//        cb_jyjgN.setChecked(info.getJyjg()==null?false: info.getJyjg().equals("1"));
//        cb_jyjgN.setOnClickListener(new MyListenerCB("0"));
//
//    }
//
//    class MyListenerCB implements View.OnClickListener {
//        private String stand;
//
//        public MyListenerCB(String _stand) {
//            stand = _stand;
//        }
//
//        @Override
//        public void onClick(View v) {
//            CheckBox cb = (CheckBox) v;
//            //Toast.makeText(Main3Activity.this, cb.getTag().toString(), Toast.LENGTH_SHORT).show();
//            cb.setChecked(cb.getTag().toString().equals(this.stand));
//        }
//    }
}