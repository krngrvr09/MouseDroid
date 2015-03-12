import socket
import sys
import re
from pymouse import PyMouse
from pykeyboard import PyKeyboard
# Create a TCP/IP socket
m= PyMouse()
k= PyKeyboard()
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Bind the socket to the port
server_address = ('192.168.54.217', 10000)
print >>sys.stderr, 'starting up on %s port %s' % server_address
sock.bind(server_address)

while True:
    print >>sys.stderr, '\nwaiting to receive message'
    data, address = sock.recvfrom(4096)
    cur_pos_x, cur_pos_y = m.position()

    print >>sys.stderr, 'received %s bytes from %s' % (len(data), address)
    print >>sys.stderr, data
    print data.split()
    data = data.split()[3]
    if "keycode" in data:
        print "pressing the key"
        which_key = data.split("_")[1]
        if(which_key=="enter"):
            print "pressing enter"
            k.tap_key("Return")
        elif(which_key=="dot"):
            print "pressing dot"
            k.tap_key(".")
        elif(which_key=="backspace"):
            print "pressing backspace"
            k.tap_key("BackSpace")
        elif(which_key=="enter"):
            print "pressing space"
            k.tap_key(" ")
        else:
            k.tap_key(which_key)
    elif "click" in data:
        print "clicking"
        m.click(cur_pos_x,cur_pos_y);
    elif "doubl" in data:
        print "double clicking"
        m.click(cur_pos_x,cur_pos_y);
        m.click(cur_pos_x,cur_pos_y);
    elif "righ" in data:
        print "right clicking"
        m.click(cur_pos_x,cur_pos_y,3);
    else:
        x_coord = data.split(";")[0]
        y_coord = data.split(";")[1]
        print x_coord
        print y_coord
        x_coord = x_coord.split("=")[1]
        str_x_coord = re.match(r'^-?\d+(\.\d+)?$', x_coord).group()
        str_y_coord = re.match(r'^-?\d+(\.\d+)?$', y_coord).group()
        if( str_x_coord and  str_y_coord):
            #print "inside if"
            x_pos = int(str_x_coord)
            y_pos = int(str_y_coord)
            #print x_pos
            #print y_pos
            try:
                #autopy.mouse.move(x_pos,y_pos)
                m.move(cur_pos_x+x_pos,cur_pos_y+y_pos)
            except ValueError:
                print "value error"

    if data:
        sent = sock.sendto(data, address)
        print >>sys.stderr, 'sent %s bytes back to %s' % (sent, address)
