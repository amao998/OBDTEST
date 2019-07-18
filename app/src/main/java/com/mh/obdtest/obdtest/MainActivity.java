package com.mh.obdtest.obdtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import com.jbt.mds.sdk.diagnosis.dtc.Dtc;
import com.jbt.mds.sdk.model.DataStreamInfo;
import com.jbt.mds.sdk.obd.AbortCode;
import com.jbt.mds.sdk.obd.IObdDetector;
import com.jbt.mds.sdk.obd.ObdDetector;
import com.jbt.mds.sdk.model.ECUInfo;
import java.util.List;


public class MainActivity extends AppCompatActivity implements IObdDetector {
    private static final String TAG = "ObdDetector";

    private ObdDetector mObdDetector;

    // 车辆类型 0 汽油车， 1 柴油车
    private int vehicleType = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mObdDetector = ObdDetector.getInstance();
        mObdDetector.init(this, this);

        findViewById(R.id.connectVci).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mObdDetector.commInit("501903000139", "3481F48480F0",
                        "0960", true, true);

                //mObdDetector.commInit("501800000215", "3481F44D19DD",
                //        "2270", true, true);

                MyPopupWindow     popupwindow=new MyPopupWindow(MainActivity.this, null);
                popupwindow.showAtLocation(MainActivity.this.findViewById(R.id.diconnectVci), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);


            }
        });

        findViewById(R.id.startScan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 初始化检测资源
                vehicleType = 0;
                mObdDetector.obdDiagnosisInit();
            }
        });

        findViewById(R.id.startScan1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 初始化检测资源
                vehicleType = 1;
                mObdDetector.obdDiagnosisInit();
            }
        });


        findViewById(R.id.stopTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 停止检测
                mObdDetector.stopTest();
            }
        });

        findViewById(R.id.setSingleDataStreamMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 设置为对其单条数据流模式
                boolean result = mObdDetector.setReadSingleDataStreamMode("00012000");

                if (result == false) {
                    Toast.makeText(MainActivity.this, "尚未启动检测或不存在该数据流", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.cancelSingleDataStreamMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mObdDetector.cancelReadSingleDataStreamMode();
            }
        });

        findViewById(R.id.getDtc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Dtc> dtcs = mObdDetector.getDtc();
                for (Dtc dtc : dtcs) {
                    Log.i(TAG, dtc.toString());
                }
            }
        });

        findViewById(R.id.getIUPRMsg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<DataStreamInfo> iuprStates = mObdDetector.getIUPRState();
                for (DataStreamInfo info : iuprStates) {
                    Log.i(TAG, info.toString());
                }
            }
        });

        findViewById(R.id.getVinCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vin = mObdDetector.getVin();

                Log.i(TAG, "getDtc onClick: " + vin);
            }
        });


        findViewById(R.id.getECUInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ECUInfo> ecuInfos = mObdDetector.getECUInfo();
                for (ECUInfo info : ecuInfos) {
                    Log.i(TAG, info.toString());
                }
            }
        });

        findViewById(R.id.getSystemState).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<DataStreamInfo> systemStates = mObdDetector.getSystemCheckState();
                for (DataStreamInfo systemState : systemStates) {
                    Log.i(TAG, "就绪状态：" + systemState.toString());
                }
            }
        });

        findViewById(R.id.diconnectVci).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mObdDetector.disconnectVci();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObdDetector.getInstance().disconnectVci();
    }

    /**
     * 检测资源初始化完毕, 可以开始检测了..
     */
    @Override
    public void obdDiagnosisInitFinish() {
        Log.i(TAG, "obdDiagnosisInitFinish");
        // vehicleType = 0 汽油车型，vehicleType = 1 柴油车型，
        mObdDetector.startTest(vehicleType);
    }

    /**
     * 当产生这个回调, 说明已激活成功, 然后可以读取所需的数据
     */
    @Override
    public void activeSuccess() {
        Toast.makeText(this, "activeSuccess", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "activeSuccess:");
    }

    /**
     * 执行stopTest, 当完全退出检测时, 产生的回调.
     */
    @Override
    public void stopFinish() {
        Log.i(TAG, "stopFinish:");
    }

    /**
     * 检测过程中, 发生异常产生的回到
     *
     * @param abortCode
     */
    @Override
    public void abortError(AbortCode abortCode) {
        Log.i(TAG, "abortError abortCode:" + abortCode);
    }

    /**
     * 环保检测过程中, 实时数据刷新产生的回调
     *
     * @param dataStreamInfo
     */
    @Override
    public void updateDataStream(DataStreamInfo dataStreamInfo) {
        Log.i(TAG, "updateDataStream:" + dataStreamInfo.toString());
    }

    /**
     * 环保检测过程中, 实时监控故障码产生的回调
     *
     * @param realDtcs
     */
    @Override
    public void updateRealDtc(List<Dtc> realDtcs) {
        for (Dtc realDtc : realDtcs) {
            Log.i(TAG, "updateRealDtc: " + realDtc.toString());
        }
    }

    /**
     * 环保检测结束, 及结束检测时, 读冻结帧数据参数的回调
     *
     * @param realFreezeFrameDataStream
     */
    @Override
    public void updateRealFreezeFrameDataStream(List<DataStreamInfo> realFreezeFrameDataStream) {

        for (DataStreamInfo dataStreamInfo : realFreezeFrameDataStream) {
            Log.i(TAG, "updateRealFreezeFrameDataStream: " + dataStreamInfo.toString());
        }
    }

    /**
     * VCI连接状态变化时发生回调
     * @param vciConnectState
     */
    @Override
    public void updateVciConnectedState(int vciConnectState) {
        Log.i(TAG, "updateVciConnectedState: vciConnectState：" + vciConnectState);
    }
}

