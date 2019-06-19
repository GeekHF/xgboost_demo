# xgboost_demo

I used the demo.java load a pre-trained xgboost model and make some prediction.

The running time of booster.predict line in linus is much slower than the time in windows

Both jdk are 
'''
java 11.0.1 2018-10-16 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.1+13-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.1+13-LTS, mixed mode)
'''
In windows, I used the xgboost4j-0.82-criteo-20190412_2.11-win64

In linux(centos), I used xgboost4j version 0.81, 0.82, 0.90, with the official jars and the xgboost4j-0.82-criteo-20190412_2.11-linux.jar. Running times are all the same, and all quite slow when comparing with windows.

The output of windows and linux are in the text files with prefix "duration_"

