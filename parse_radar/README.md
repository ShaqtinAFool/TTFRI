<!-- MarkdownTOC -->

- [作者](#%E4%BD%9C%E8%80%85)
- [雷達代號](#%E9%9B%B7%E9%81%94%E4%BB%A3%E8%99%9F)
- [前言](#%E5%89%8D%E8%A8%80)
- [軟體與安裝](#%E8%BB%9F%E9%AB%94%E8%88%87%E5%AE%89%E8%A3%9D)
	- [讀雷達資料所需的軟體和模組](#%E8%AE%80%E9%9B%B7%E9%81%94%E8%B3%87%E6%96%99%E6%89%80%E9%9C%80%E7%9A%84%E8%BB%9F%E9%AB%94%E5%92%8C%E6%A8%A1%E7%B5%84)
	- [安裝流程](#%E5%AE%89%E8%A3%9D%E6%B5%81%E7%A8%8B)
- [讀檔](#%E8%AE%80%E6%AA%94)
	- [Rainbow5](#rainbow5)
	- [NEXRAD level2](#nexrad-level2)
- [參考資料](#%E5%8F%83%E8%80%83%E8%B3%87%E6%96%99)

<!-- /MarkdownTOC -->

---

# 作者
中央大學大氣系雷達實驗室羅同學

---

# 雷達代號
依照ICAO的編碼法，雷達站代碼如以下

- 氣象局
	- RCWF: 五分山
	- RCHL: 花蓮
	- RCCG: 七股
	- RCKT: 墾丁
- 民航局
	- RCTP: 桃園機場
- 國防部
	- RCMQ: 清泉崗
	- RCQC: 馬公
	- RCLT: 綠島

---

# 前言
目前氣象局的雷達資料格式有以下兩種
- Rainbow5: 花蓮、墾丁、七股、五分山和軍方雷達  
	若下載的檔案為 **xxxdBZ.vol** 表示是Rainbow5的資料格式，使用編輯器打開檔案可以看到 XML 的檔頭，裡面記錄著這個檔案的各種訊息和資料結構。  
	![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig01.png)
- NEXRAD level2: 部分時段五分山  
	若檔案是 **xxxx.VOL.001、xxxx.VOL.002** 等檔名則是屬 NEXRAD level2 的檔案結構，基本上它是個二進位檔所以打開看到的都會是亂碼。  

為了讓使用者可以使用這兩種資料，以下介紹網上社群寫好的讀檔程式的安裝和使用。目前網路上開源且可以處理氣象局 Rainbow5 資料格式的程式僅有 TITAN 和 Wradlib 支援:

- TITAN 是美國國家大氣研究中心(NCAR)的開源計畫，雖然支援較多檔案格式但安裝複雜且程式占較大空間(1GB以上)
- Wradlib 則是 python 的模組之一，其安裝簡單且體積小、使用相對容易，但 wradlib 不支援 NEXRAD level2 的檔案格式，因此我們需要再安裝 Py-art 來支援讀取，安裝完這兩個模組大部分的雷達資料格式都可以使用了。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig02.png)

---

# 軟體與安裝
## 讀雷達資料所需的軟體和模組
- Python2.7
- Wradlib
	- python module (http://wradlib.org/wradlib-docs/latest/)
- Py-art
	- python module (http://arm-doe.github.io/pyart/)

## 安裝流程
### Python
若電腦上無 python 的使用者，可以至 https://www.continuum.io/downloads 網站上下載，並選適合使用者電腦系統的 Anaconda，它是一個安裝包包含 python 和很多常用的模組，例如 numpy、matplotlib 等等。Anaconda 安裝有分成 python3 和 python2 的版本，請選擇 **python2** 的版本來安裝。亦可下載精簡的 Miniconda 版本，一樣是選擇 python2。

1. Linux 設定環境變數
	- vi ~/.bashrc
	- export PATH=/usr/local/bin/anaconda2/bin:$PATH
	- source ~/.bashrc

	![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig03.png)

1. Windows 設定環境變數，如下箭頭順序

	![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig04.png)

### Wradlib
這是一個可讀取 Rainbow5 檔案的模組，為了避免軟體間使用版本不同而衝突的問題，先創建一個環境叫 wradlib。

- Linux：在終端機作業
- Windows：在 Anaconda Prompt 作業
1. 輸入以下資訊
	- $ conda create --name wradlib

	![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig05.png)
1. 注意：若使用者本來的 python 是第 3 版，則是創建一個 python2 的環境
	- $ conda create --name wradlib python=2.7
1. 之後加入 wradlib 所在的軟體庫 conda-forge
	- $ conda config --add channels conda-forge

	![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig06.png)
1. 最後完成後，如果是
	1. linux 作業系統則輸入
		- $ source activate wradlib
	1. Windows 則是
		- activate wradlib

	意思是啟用這個環境，換看到$或>前面出現(wradlib)的字樣(如 Fig 7)，表示啟用環境成功，我們接下來便是要將 wradlib 安裝在這個環境裡，故要啟用他，若不啟用則會裝在原本 python 的環境下，為避免軟體間衝突安裝在新的環境比較不容易出錯。

	![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig07.png)

1. 啟用完輸入
	- (wradlib) $ conda install wradlib

1. 即開始安裝了，等待安裝完成(如 Fig 8)，結束後輸入
	- (wradlib) $ export GDAL_DATA=/path/to/anaconda/envs/wradlib/share/gdal

	注意：/path/to/anaconda/要設定成自己的路徑而不是照打。  
	因為 wradlib 會使用到 gdal 中的函數庫，故要設定 gdal 的安裝位置讓他抓到，建議將  
	gdal 環境變數，不然每次登出後再登入都要再設定一次，很麻煩。  

	![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig08.png)

	1. Linux 寫在~/.bashrc 這個檔案裡
		- (wradlib) > export GDAL_DATA=/path/to/anaconda/envs/wradlib/share/gdal

	1. Windows 版本則是
		- [wradlib] > setx GDAL_DATA C:\path\to\anaconda\envs\wradlib\Library\share\gdal

		![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig09.png)
1. 以上步驟完成後 wradlib 就已經安裝完成了，此時可以測試 wradlib 是否安裝正確。執行 python 後進入 python interactive mode 後輸入
	- import wradlib

1. 若是沒有錯誤出現，則再輸入
	- wradlib.\_\_version\_\_

1. 即會輸出 wradlib 的版本，表示 wradlib 安裝成功。以上為官網的安裝方式，官網另有其他方式可以安裝，有興趣可到官網查看。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig10.png)

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig11.png)

### Py-ART
這個模組是用來處理 NEXRAD level2 的資料，在 wradlib 安裝中若是已經將 conda-forge 加入環境則直接輸入 
- (wradlib) $ conda install arm_pyart，如 Fig 12 

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig12.png)

沒有 conda-forge 的話則是  
- (wradlib) $ conda install –c conda-forge arm_pyart 

把 wradlib 和 pyart 裝在同個環境後可一起用，不用再切換。建議再安裝一個 basemap，這是世界地圖的模組。
- (wradlib) $ conda install basemap

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig13.png)

以上就安裝好讀取雷達資料需要的模組了
若以後要使用時請啟用 wradlib 環境
- $ source activate wradlib

不用時則關掉
- (wradlib) $ source deactivate wradlib

---

# 讀檔
## Rainbow5
前文有提到 rainbow5 檔案在檔頭會有一段資料內容的描述，wradlib 是依照這個檔頭的內容去讀取存在檔案內的二進位資料。讀檔前首先要載入需要的模組，然後選擇要讀的檔案。之後用 wradlib 中針對 rainbow5 格式的功能進行讀檔。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig14.png)

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig15.png)

圖中的字典是 python 的一個功能，由 read_Rainbow 回傳，和檔頭 xml 的對應(Fig 16)。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig16.png)

這很像是書的目錄一樣，大目錄裡面會對應小目錄，根據目錄去找你要的東西，上面 rbdict['volume']['scan']['pargroup']['numele']的結果便是2。在 pargroup 下還有其他的子字典如 stoprange，如要讀取 stoprange 的值便是將上面改成 rbdict['volume']['scan']['pargroup']['stoprange']即可。

那如果遇到目錄的名字重複出現該怎麼辦呢?氣象局的雷達資料便是不同仰角但都在同一個名稱的字典下(Fig 17)。這張圖有好多的 slice，每個 slice 表示不同仰角資料所放的地方，這時候讀到的 slice 就變成了一個 list，也就是 slice[0], slice[1]…這樣，必須要指定哪一個區塊是你要的才可以繼續選擇後面的目錄。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig17.png)

利用這些工具可以很容易的讀到你想要的資訊，Fig 18是讀檔案的範例。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig18.png)

為了讀取每一個仰角的資料，我們勢必要做個迴圈才行，在檔案裡 slice[0], slice[1], …是從最低仰角開始往高仰角增加，如以Fig 19方式讀取會從最低仰角開始讀資料。azi 指的是方位角，有 360 個或是 361 個，讀進來的資料要經過換算才是角度。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig19.png)

這邊解釋一下 stoprange 和 rangestep，stoprange 是指雷達能夠掃描的最大距離(Fig 20左，黑線長度)，rangestep 則是每一個徑向方向格點的寬度(Fig 20右)。這兩個都是在定每個回波位置會用到的參數。再來是雷達偵測到的資料本身，同樣要經過換算才會得到 dBZ。由於是原始的雷達資料，一些干擾、非氣象回波等沒有被濾除，因此使用時要注意。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig20.png)

Fig 21的 Data 維度是[方位角, 徑向格點]組成，[方位角]的大小和 azi 一致而[徑向格點]和Fig 20的 r 一致，r 是每個格點離雷達中心的距離，單位是公里。再來便是畫圖的設定，畫雷達資料時也會用到 wradlib 的函數，用它的函數可以方便畫出同心圓的雷達圖(Fig 22)。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig21.png)

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig22.png)

執行 rainvow5.py，成功(如Fig 23)並產圖(如Fig 25)。如果出現錯誤，如Fig 24，則需安裝 xmltodict，安裝方式如以下：

1. sudo apt-get -f install
1. sudo apt-get install python-pip
1. 改 /usr/local/bin/anaconda2/bin/pip 第一行(預設是/home/YourAccount/anaconda2)
1. pip install xmltodict

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig23.png)

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig24.png)

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig25.png)

## NEXRAD level2

**NEXRAD level2** 格式目前只有一段時間的五分山資料是用這個，當副檔名是 xxx.VOL.001、xxx.VOL.002 …等，表示它是 NEXRAD 的檔案，這時我們要用 pyart 的模組來讀取它，在 pyart 官網中有很多寫好的範例，以下用其中一個範例來講解檔案內容。

首先要載入讀檔所需的模組，利用 pyart 的函數 read_nexrad_archive 讀取檔案(Fig 26)，檔案的資料會存在 radar 這個變數中，此時要知道檔案中有什麼資訊可以輸出 radar.info() 的內容，當中包含觀測的dBZ、徑向風和資料的維度等訊息。下圖為輸出結果的一部份，有雷達的經緯度、掃幾層、徑向格點數、方位角格點數等。Fig 27 中的 3960 是 360\*11 為一圈有 360 個角度且掃了 11 層。可以用 radar.get_field(第幾層,'觀測場') 來找出某一層的雷達資料，例如 radar.get_field(0, 'reflectivity') 是抓最低層反射率的資料，此時資料的維度為\[360, 184]。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig26.png)

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig27.png)

繪圖的部分同樣會使用到 pyart 中的函數，更多功能可以在官網中找到，下圖是個範例(Fig 28)和畫出來的圖(Fig 29)，可以看到一個明顯的颱風眼。

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig28.png)

![image](https://github.com/ShaqtinAFool/TTFRI/blob/master/parse_radar/figure/fig29.png)

---

# 參考資料
1. http://journals.ametsoc.org/doi/pdf/10.1175/BAMS-D-13-00240.1
1. http://wradlib.org/wradlib-docs/0.9.0/index.html
1. http://arm-doe.github.io/pyart-docs-travis/index.html
1. http://www.ral.ucar.edu/projects/titan/home/


