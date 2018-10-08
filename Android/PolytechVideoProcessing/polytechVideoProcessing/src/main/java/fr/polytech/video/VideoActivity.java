package fr.polytech.video;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Toast;


public class VideoActivity extends Activity implements CvCameraViewListener2 {
    private static final String TAG = "OCVSample::Activity";

    private CameraBridgeViewBase mOpenCvCameraView;
    private boolean mIsJavaCamera = true;
    private MenuItem mItemSwitchCamera = null;


    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS: {
                    Log.i(TAG, "OpenCV loaded successfully");
                    mOpenCvCameraView.enableView();
                } break;
                default: {
                    super.onManagerConnected(status);
                } break;
            }
        }
    };

	private byte[] outarray;
	private int w;
	private int h;

    public VideoActivity() {
        Log.i(TAG, "Instantiated new " + this.getClass());
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Called onCreate.");

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.tutorial1_surface_view);

        mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.tutorial1_activity_java_surface_view);
        mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
        mOpenCvCameraView.setCvCameraViewListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!OpenCVLoader.initDebug()) {
            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization.");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        }
        else {
            Log.d(TAG, "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }

    public void onDestroy() {
        super.onDestroy();

        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    public void onCameraViewStarted(int width, int height) {
    	outarray = new byte[width*height];
    	w=width;
    	h=height;
    }

    public void onCameraViewStopped() {
    }

    public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
    	Mat gray = inputFrame.gray();
    	MatToArray(gray);

    	//byte[] new_array = Gradiant(outarray);
        byte[] new_array = Sobel(outarray);

    	Mat out = ArrayToMat(gray, w, h, new_array);
    	return out;
    }

    private Mat ArrayToMat(Mat gray, int w, int h, byte[] grayarray) {
		// TODO : Auto-generated method stub.
		Mat out = gray.clone(); //new Mat(w, h, CvType.CV_8UC1);
		out.put(0,0, grayarray);

		return out;
	}

	private void MatToArray(Mat gray) {
		// TODO : Auto-generated method stub.
		gray.get(0, 0, outarray);
	}

    private byte[] Gradiant(byte[] array) {
        int x, y;
        byte gradH, gradV;
        byte[] gradiant_array = new byte[w*h];

        for(x = 1; x < w - 1; x++) {
            for(y = 1; y < h - 1; y++) {
                gradH = (byte) (array[y * w + x - 1] - array[y * w + x + 1]);
                gradV = (byte) (array[(y - 1) * w + x] - array[(y + 1) * w + x]);
                gradiant_array[y * w + x] = (byte) Math.abs(gradH + gradV);
            }
        }

        return gradiant_array;
    }

    private byte[] Sobel(byte[] array) {
        int x, y, m_x, m_y;
        int filter[][] = new int[3][3];
        byte[] sobel_array = new byte[w*h];

        filter[0][0] = -1;
        filter[0][1] = 0;
        filter[0][2] = 1;
        filter[1][0] = 2;
        filter[1][1] = 0;
        filter[1][2] = 2;
        filter[2][0] = 1;
        filter[2][1] = 0;
        filter[2][2] = 1;

        for(x = 1; x < w - 1; x++)
            for(y = 1; y < h - 1; y++) {
                sobel_array[y * w + x] = 0;

                for(m_x = 0; m_x < 3; m_x++)
                    for(m_y = 0; m_y < 3; m_y++)
                        sobel_array[y * w + x] += filter[m_x][m_y] * outarray[(y + (m_y-1)) * w + (x + (m_x-1))];
            }

        return sobel_array;
    }

    public native void ProcessFast(int width, int height, byte input[], byte output[]);
    static {
        System.loadLibrary("native_sample");
    }
}
