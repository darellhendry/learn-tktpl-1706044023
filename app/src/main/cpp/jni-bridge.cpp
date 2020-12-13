#include <jni.h>
#include <android/input.h>

extern "C" {
    JNIEXPORT jdouble JNICALL
    Java_id_ac_ui_cs_mobileprogramming_darellhendry_helloworld_MainActivity_add(JNIEnv *env, jobject obj, jdouble a, jdouble b) {
        return a + b;
    }
}


