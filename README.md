###### An Android app that pushes the phone number of an incoming call to web app ##########

=> Start the AVD:
$ emulator -shell -show-kernel -avd HTC-PG762

=> Start following the log:
$ adb logcat

=> Connect to the emulator so that you can simulate a phone call:
$ adb devices -l
List of devices attached 
emulator-5554          device

$ telnet localhost 5554
Trying 127.0.0.1...
Connected to localhost.
Escape character is '^]'.
Android Console: type 'help' for a list of commands
OK
gsm call 1234567890

=> Build the code:
$ ant clean
$ ant debug

=> Install the packaged app to the emulator:
$ ant debug install
