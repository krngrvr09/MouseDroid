# from distutils.core import setup
# setup(
#   name = 'mouse_droid',
#   packages = ['mouse_droid'], # this must be the same as the name above
#   version = '0.1',
#   description = 'mouse droid package',
#   author = 'Karan Grover',
#   author_email = 'krngrvr09@gmail.com',
#   url = 'https://github.com/krngrvr09/MouseDroid', # use the URL to the github repo
#   download_url = 'https://github.com/krngrvr09/mouse_droid/tarball/0.1', # I'll explain this in a second
#   keywords = ['mouse', 'android', 'python'], # arbitrary keywords
#   classifiers = [],
# )

from distutils.core import setup

setup(name='mouse_droid',
      version='0.1.1',
      description='Control Mouse via pointer',
      author='Karan Grover',
      author_email='krngrvr09@gmail.com',
      scripts=['mouse_droid/droidserver']
      url = 'https://github.com/krngrvr09/MouseDroid', # use the URL to the github repo
      download_url = 'https://github.com/krngrvr09/mouse_droid/tarball/0.1', # I'll explain this in a second
      keywords = ['mouse', 'android', 'python'], # arbitrary keywords
     )