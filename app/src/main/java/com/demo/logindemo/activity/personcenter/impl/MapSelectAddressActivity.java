package com.demo.logindemo.activity.personcenter.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.demo.logindemo.R;
import com.demo.logindemo.util.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapSelectAddressActivity extends AppCompatActivity {


    @BindView(R.id.iv_activity_map_select_address_return)
    ImageView ivActivityMapSelectAddressReturn;
    @BindView(R.id.iv_activity_map_select_address_share)
    ImageView ivActivityMapSelectAddressShare;
    @BindView(R.id.mv_activity_map_select_address_map)
    MapView mvActivityMapSelectAddressMap;
    @BindView(R.id.btn_activity_map_select_address_normal)
    Button btnActivityMapSelectAddressNormal;
    @BindView(R.id.btn_activity_map_select_address_satellite)
    Button btnActivityMapSelectAddressSatellite;
    @BindView(R.id.btn_activity_map_select_address_traffic)
    Button btnActivityMapSelectAddressTraffic;
    @BindView(R.id.btn_activity_map_select_address_heat)
    Button btnActivityMapSelectAddressHeat;

    private BaiduMap mBaiduMap;

    private Context context;

    //定位相关
    private LocationClient mLocationClient;
    private MyLocationListener mLocationListener;
    private boolean isFirstIn = true;
    private double mLatitude;
    private double mLongtitude;

    //自定义定位图标
    private BitmapDescriptor mIconLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_map_select_address);
        ButterKnife.bind(this);
        this.context = this;
        initView();
        //初始化定位
        initLocation();
        //地图标注
//        mapLabel();

    }

    private void mapLabel() {
        //定义Maker坐标点
        LatLng point = new LatLng(39.963175, 116.400244);
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.label);

        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)//设置marker的位置
                .icon(bitmap)//设置marker图标

                //第一步，设置可拖拽：
                .zIndex(9)  //设置marker所在层级
                .draggable(true);  //设置手势拖拽


        //在地图上添加Marker，并显示
        // 将marker添加到地图上
        Marker marker = (Marker) (mBaiduMap.addOverlay(option));


//        //第二步，设置监听方法：
//        // 调用BaiduMap对象的setOnMarkerDragListener方法设置marker拖拽的监听
//        mBaiduMap.setOnMarkerDragListener(new BaiduMap.OnMarkerDragListener() {
//            public void onMarkerDragStart(Marker marker) {
//                //开始拖拽
//            }
//            public void onMarkerDrag(Marker marker) {
//                //拖拽中
//            }
//            public void onMarkerDragEnd(Marker marker) {
//                //拖拽结束
//            }
//        });

//        //给Marker增加动画
//        // 通过marker的icons设置一组图片，再通过period设置多少帧刷新一次图片资源
//        ArrayList<BitmapDescriptor> giflist = new ArrayList<BitmapDescriptor>();
//        giflist.add(bitmap);
//        giflist.add(bitmap);
//        giflist.add(bitmap);
//        OverlayOptions ooD = new MarkerOptions()
//                .position(point)
//                .icons(giflist)
//                .zIndex(0)
//                .period(10);
//        marker = (Marker) (mBaiduMap.addOverlay(ooD));

//        marker.remove();   //调用Marker对象的remove方法实现指定marker的删除

////        自v3.6.0版本起，SDK提供了给加载Marker增加动画的能力，加载maker时包含两种加载动画方式：从地上生长和从天上落下。
////        以生长动画为例，具体实现方法如下：
//        MarkerOptions llD = new MarkerOptions()
//                .position(point)
//                .icons(giflist)
//                .zIndex(0)
//                .period(10);
//        if (animationBox.isChecked()) {
//            // 生长动画
//            llD.animateType(MarkerOptions.MarkerAnimateType.grow);
//        }
//        Marker  mMarkerD = (Marker) (mBaiduMap.addOverlay(llD));

////        自v3.6.0版本起，SDK提供了给Marker设置透明度的方法，具体实现方法如下：
//        MarkerOptions ooA = new MarkerOptions().position(point).icons(giflist)
//                .zIndex(0).period(10).alpha(0.5f);
//        mBaiduMap.addOverlay(ooA);


    }

    /**
     * 初始化定位
     */
    private void initLocation() {
        mLocationClient = new LocationClient(this);
        mLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(mLocationListener);

        LocationClientOption option = new LocationClientOption();
        option.setCoorType("bd0911");
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setScanSpan(1000);

        mLocationClient.setLocOption(option);


        //初始化图标
        mIconLocation = BitmapDescriptorFactory.fromResource(R.drawable.ic_navigation_black_24dp);

    }

    private void initView() {

        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);//获取地图比例
        mBaiduMap = mvActivityMapSelectAddressMap.getMap();
        mBaiduMap.setMapStatus(msu);//设置地图比例

    }

    @Override
    protected void onStart() {
        super.onStart();
        mBaiduMap.setMyLocationEnabled(true);
        if (mLocationClient.isStarted()){
            mLocationClient.start();//开启定位
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mvActivityMapSelectAddressMap.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();

        mBaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mvActivityMapSelectAddressMap.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mvActivityMapSelectAddressMap.onResume();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.id_map_common:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.id_map_site:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.id_map_traffic:
                if (mBaiduMap.isTrafficEnabled()) {
                    mBaiduMap.setTrafficEnabled(false);
                    item.setTitle("实时交通（off）");

                } else {
                    mBaiduMap.setTrafficEnabled(true);
                    item.setTitle("实时交通（on）");
                }
                break;
            case R.id.id_map_location:
                centerToMyLocation();

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 定位到我的位置
     */
    private void centerToMyLocation() {
        LatLng latLng = new LatLng(mLatitude,mLongtitude);
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        mBaiduMap.animateMapStatus(msu);
    }

    @OnClick({R.id.iv_activity_map_select_address_return, R.id.iv_activity_map_select_address_share, R.id.btn_activity_map_select_address_normal, R.id.btn_activity_map_select_address_satellite, R.id.btn_activity_map_select_address_traffic, R.id.btn_activity_map_select_address_heat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_map_select_address_return:
                break;
            case R.id.iv_activity_map_select_address_share:
                //空白地图, 基础地图瓦片将不会被渲染。在地图类型中设置为NONE，将不会使用流量下载基础地图瓦片图层。使用场景：与瓦片图层一起使用，节省流量，提升自定义瓦片图下载速度。
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
                break;

            case R.id.btn_activity_map_select_address_normal:
                //普通地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.btn_activity_map_select_address_satellite:
                //卫星地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.btn_activity_map_select_address_traffic:
                if (mBaiduMap.isTrafficEnabled()){
                    ToastUtils.showLong(this,"交通图已开启");
                }else {
                    //开启交通图
                    mBaiduMap.setTrafficEnabled(true);
                }

                break;
            case R.id.btn_activity_map_select_address_heat:
                if (mBaiduMap.isBaiduHeatMapEnabled()){
                    ToastUtils.showLong(this,"热力图已开启");
                }else {
                    //开启交通图
                    mBaiduMap.setBaiduHeatMapEnabled(true);
                }

                break;
        }
    }


    private class MyLocationListener implements BDLocationListener {


        //定位成功
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            MyLocationData data = new MyLocationData.Builder()//
            .accuracy(bdLocation.getRadius())//精度
            .longitude(bdLocation.getLongitude())//
            .latitude(bdLocation.getLatitude())//方向
            .build();

            //设置自定义图标
            MyLocationConfiguration config = new MyLocationConfiguration(
                    MyLocationConfiguration.LocationMode.COMPASS,
                    true,
                    mIconLocation);
            mBaiduMap.setMyLocationConfiguration(config);

            mBaiduMap.setMyLocationData(data);

            LatLng latLng = new LatLng(bdLocation.getLatitude(),bdLocation.getLongitude());
            //更新经纬度
            mLatitude = bdLocation.getLatitude();
            mLongtitude = bdLocation.getLongitude();
            if (isFirstIn){
                centerToMyLocation();
                isFirstIn = false;

                ToastUtils.showLong(context,bdLocation.getAddrStr());

            }

        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }


}
