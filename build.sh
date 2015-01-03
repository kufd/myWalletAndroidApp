#!/bin/sh

JAVA_HOME="/usr/java/jdk1.7.0_71"
ANDROID_HOME="/home/kufd/bin/android-sdk-linux"
DEV_HOME="./"

AAPT_PATH="$ANDROID_HOME/build-tools/21.1.2/aapt"
DX_PATH="$ANDROID_HOME/build-tools/21.1.2/dx"
ANDROID_JAR="$ANDROID_HOME/platforms/android-21/android.jar"
ADB="$ANDROID_HOME/platform-tools/adb"

PACKAGE_PATH="com/app"
PACKAGE="com.app"
MAIN_CLASS="MainActivity"

rm -rf $DEV_HOME/bin/*

$AAPT_PATH package -f -m -S $DEV_HOME/res -J $DEV_HOME/src -M $DEV_HOME/AndroidManifest.xml -I $ANDROID_JAR

$JAVA_HOME/bin/javac -d $DEV_HOME/obj -cp $ANDROID_JAR -sourcepath $DEV_HOME/src $DEV_HOME/src/$PACKAGE_PATH/*.java

$DX_PATH --dex --output=$DEV_HOME/bin/classes.dex $DEV_HOME/obj

$AAPT_PATH package -f -M $DEV_HOME/AndroidManifest.xml -S $DEV_HOME/res -I $ANDROID_JAR -F $DEV_HOME/bin/AndroidTest.unsigned.apk $DEV_HOME/bin

#create signature
#$JAVA_HOME/bin/keytool -genkey -validity 10000 -dname "CN=AndroidDebug, O=Android, C=US" -keystore $DEV_HOME/AndroidTest.keystore -storepass android -keypass android -alias androiddebugkey -keyalg RSA -v -keysize 2048
$JAVA_HOME/bin/jarsigner -sigalg SHA1withRSA -digestalg SHA1 -keystore $DEV_HOME/AndroidTest.keystore -storepass android -keypass android -signedjar $DEV_HOME/bin/AndroidTest.signed.apk $DEV_HOME/bin/AndroidTest.unsigned.apk androiddebugkey


$ADB uninstall $PACKAGE
$ADB install $DEV_HOME/bin/AndroidTest.signed.apk
$ADB shell am start $PACKAGE/$PACKAGE.$MAIN_CLASS
