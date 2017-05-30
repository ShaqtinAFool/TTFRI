<!-- MarkdownTOC -->

- [抓系集資料](#%E6%8A%93%E7%B3%BB%E9%9B%86%E8%B3%87%E6%96%99)
	- [層場圖](#%E5%B1%A4%E5%A0%B4%E5%9C%96)
	- [雨量\(測站、網格\)](#%E9%9B%A8%E9%87%8F%E6%B8%AC%E7%AB%99%E3%80%81%E7%B6%B2%E6%A0%BC)
	- [路徑](#%E8%B7%AF%E5%BE%91)
- [抓網路資料](#%E6%8A%93%E7%B6%B2%E8%B7%AF%E8%B3%87%E6%96%99)
	- [海象](#%E6%B5%B7%E8%B1%A1)
	- [開放資料](#%E9%96%8B%E6%94%BE%E8%B3%87%E6%96%99)
	- [文化大氣\(http://twister.atmos.pccu.edu.tw/ssl/sslbank/\)](#%E6%96%87%E5%8C%96%E5%A4%A7%E6%B0%A3httptwisteratmospccuedutwsslsslbank)
	- [雷達閃電](#%E9%9B%B7%E9%81%94%E9%96%83%E9%9B%BB)
	- [雨量圖](#%E9%9B%A8%E9%87%8F%E5%9C%96)
	- [衛星雲圖](#%E8%A1%9B%E6%98%9F%E9%9B%B2%E5%9C%96)
	- [TRMM](#trmm)
- [抓FTP](#%E6%8A%93ftp)
	- [衛星雲圖](#%E8%A1%9B%E6%98%9F%E9%9B%B2%E5%9C%96-1)

<!-- /MarkdownTOC -->

---

# 抓系集資料
## 層場圖
	scp -r tyttfri@*.*.*.91:/data/archive/image/2015 ./Image/  

## 雨量(測站、網格)
	待確認，可能會有路徑干擾  
	scp -r tyttfri@*.*.*.91:/data/archive/data/2015 ./Rain/  

## 路徑

# 抓網路資料
## 海象
	get-mmc.sh

## 開放資料
	get-opendata.sh

## 文化大氣(http://twister.atmos.pccu.edu.tw/ssl/sslbank/)
	get-pccu.sh

## 雷達閃電
	get-radar.sh

## 雨量圖
	get-rain.sh

## 衛星雲圖
	get-sate.sh

## TRMM
	get-trmmRain.sh

# 抓FTP
## 衛星雲圖
	get-sateFTP.sh
