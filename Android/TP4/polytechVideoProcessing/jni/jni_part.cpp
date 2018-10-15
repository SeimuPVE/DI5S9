#include <jni.h>
#include <math.h>

using namespace std;

extern "C" {
	JNIEXPORT void JNICALL Java_fr_polytech_video_VideoActivity_ProcessFast(JNIEnv* env,
			jobject thiz, jint width, jint height, jbyteArray data, jbyteArray out)
	{
		jbyte* _data = env->GetByteArrayElements(data, 0);
		jbyte* _out = env->GetByteArrayElements(out, 0);

		// Stuff todo here.

		env->ReleaseByteArrayElements(data, _data, 0);
		env->ReleaseByteArrayElements(out, _out, 0);
	}
}

