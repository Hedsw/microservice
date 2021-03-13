from urllib.request import urlopen
from urllib.parse import quote_plus
from bs4 import BeautifulSoup
import urllib.request as urllib2
import re
import requests
import wget
import base64
import os
from subprocess import Popen

baseUrl = 'https://disc2.gesdisc.eosdis.nasa.gov/data/TRMM_RT/TRMM_3B42RT_Daily.7/2002/01/'

#requests.get(https+baseUrl, auth=HTTPDigestAuth(username, password))
#wget.download(https+baseUrl+filename, filename)

req = urllib2.Request(baseUrl)
sourcecode = urllib2.urlopen(baseUrl).read()
soup = BeautifulSoup(sourcecode, 'html.parser')

p = Popen(['watch', 'ls'])
for href in soup.find("table").find_all('a', href=re.compile("nc4$")): #시부레 왜 두번 들어가지.?
    #print(baseUrl + href["href"])
    fname = href["href"]
    #print(fname)
# asynchronously way  -> https://stackoverflow.com/questions/636561/how-can-i-run-an-external-command-asynchronously-from-python

    try:
        print(baseUrl)
        #os.system("wget --load-cookies cookies.txt --accept=exe {}".format(url))

    except Exception as e:
            print(" File not found, please refer to the website manually for download link", e)
p.terminate()
#wget.download(url, 'success.nc4')

print(" ")
print(" ")
print(" ")

print(baseUrl + "   <--- Directory Download Finished")
print(" ")
print(" ")


















# 아래와 같이 파일 이름에 따라서 불러오게 만들었음 
# 동기식으로 작성.. Synchronous way 
'''
for i in range(5):
    try:
        print(https + baseUrl + filename)
        os.system('wget --user gogod951 --password dbsGUR123@# https://disc2.gesdisc.eosdis.nasa.gov/data/TRMM_RT/TRMM_3B42RT_Daily.7/2002/01/%s' %filename)
        #os.system("wget --load-cookies cookies.txt --accept=exe {}".format(url))

    except Exception as e:
            print(" File not found, please refer to the website manually for download link", e)
'''

#여기서 이제 파싱해서 파일 이름을 가져가야한다.. 씨부레 
'''
req = urllib2.Request(baseUrl)
sourcecode = urllib2.urlopen(baseUrl).read()
soup = BeautifulSoup(sourcecode, 'html.parser')

for href in soup.find("table").find_all('a', href=re.compile("nc4$")): #시부레 왜 두번 들어가지.?
    #print(baseUrl + href["href"])
    fname = href["href"]
    print(fname)
  

# asynchronously way  -> https://stackoverflow.com/questions/636561/how-can-i-run-an-external-command-asynchronously-from-python
p = Popen(['watch', 'ls'])
for i in range(5):
    try:
        print(baseUrl)
        os.system('wget --user gogod951 --password dbsGUR123@# https://disc2.gesdisc.eosdis.nasa.gov/data/TRMM_RT/TRMM_3B42RT_Daily.7/2002/01/%s' %filename)
        #os.system("wget --load-cookies cookies.txt --accept=exe {}".format(url))

    except Exception as e:
            print(" File not found, please refer to the website manually for download link", e)
p.terminate()
#wget.download(url, 'success.nc4')

print("Download Finished")
'''
