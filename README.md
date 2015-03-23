# MouseDroid
Control the mouse pointer and keyboard with your android, wirelessly.

This project requires you to have a ``droidserver`` running on your machine, and an android app that you can use as a touch pad.

The android app will be uploaded to Play Store soon. Till then you can use the apk [here](https://github.com/krngrvr09/MouseDroid/blob/master/MoveMouse/app/app-release.apk).

You can install the server in 2 steps.

1. ``$ pip install mouse_droid``
2. ``sudo pip install svn+https://svn.code.sf.net/p/python-xlib/code/trunk/``


Run `` $ droidserver`` to start the UDP Server.

When running the app, Enter the IP Address of the computer you want to connect to. And then start using it.

Successfully tested on Ubuntu 13.10
