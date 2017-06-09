# 目錄

<!-- MarkdownTOC detph=5 -->

- [1.擴充案進度](#1%E6%93%B4%E5%85%85%E6%A1%88%E9%80%B2%E5%BA%A6)
	- [1-1 去年擴充案](#1-1-%E5%8E%BB%E5%B9%B4%E6%93%B4%E5%85%85%E6%A1%88)
	- [1-2 今年擴充案](#1-2-%E4%BB%8A%E5%B9%B4%E6%93%B4%E5%85%85%E6%A1%88)
- [2.例行作業](#2%E4%BE%8B%E8%A1%8C%E4%BD%9C%E6%A5%AD)
- [3. 主機概況](#3-%E4%B8%BB%E6%A9%9F%E6%A6%82%E6%B3%81)

<!-- /MarkdownTOC -->

---

# 1.擴充案進度

## 1-1 去年擴充案
* Web：http://140.112.201.139/
* 流程
	- [ ] 因入侵關係，重灌兩台主機
	* Windows還原完畢(server序號、sql序號ok、資料表還原中…)
	* Linux安裝完畢(但無法ssh遠端，須請奕霖處理)
* UI/Bug調整：https://goo.gl/0kA36I
	* 還有3個bug項目需處理
* 白箱測試
* 部署在正式機
* 黑箱測試

	- [ ] UI/Bug調整：https://goo.gl/0kA36I
	- [ ] 白箱測試
	- [ ] 部署在正式機
	- [ ] 黑箱測試

## 1-2 今年擴充案
* Web：http://140.112.201.139:8080/
* 第一期流程
	- [ ] 需完成資料庫整體介面調整
	- [ ] 需完成資料庫資料新增
	- [ ] 需完成資料下載機制調整
	- [ ] 需繳交文件
		- 功能擴充開發服務報告
		- 業務會議紀錄
		- 維護工作報告書
			- 定期維護：http://ttfri.ragic.com/default/forms/5
			- 非定期維護：http://ttfri.ragic.com/default/forms/16

* 第二期流程
	- [ ] 需完成網站之查詢功能擴充
	- [ ] 需完成網站之展示功能擴充
	- [ ] 需完成教育訓練
	- [ ] 需繳交文件
		- 功能擴充開發服務報告
		- 業務會議紀錄
		- 維護工作報告書
			- 定期維護：http://ttfri.ragic.com/default/forms/5
			- 非定期維護：http://ttfri.ragic.com/default/forms/16

**[回到目錄](#目錄)**

# 2.例行作業
- [ ] 資料上架SOP
	+ 上架&歸檔：
		+ Online：  
			(1) 在終端機輸入"java -jar ycl14jul03a.jar"  
			(2) 跳出一個GUI介面，再按"分析服務"->"啟動"  
			(3) 使用管理者帳號到網站的"資料管理"->"新進資料准核"  
			(4) 依照"資料單位"按下"全部開放即可"  
		+ Offline：
			收即到資料後，存放在兩個位置
			+ Linux：存放在備援機(175)裡面，分別再兩個資料夾底下  
				+ /ttfriNewDBAR/ImportData   (親自索取的目錄)  
				+ /ttfriNewDBAR/GetTeamRData (索取TeamR的目錄)
				+ /ttfriNewDBAR/GetWebData   (自動抓資料的目錄)  
			+ 外接硬碟 (編號:DBAR-S-TO-001)  
	+ 紀錄：http://ttfri.ragic.com/default/iso/2
	+ 備份：
		+ 實體資料
			+ 174：/share2/ParsedFiles
			+ 175：/ttfriNewDBAR/ParsedFiles
			+ 外接硬碟
		+ SQL：備份到/share2/SQLbk/TTFRI/

- [x] 工作日誌：http://ttfri.ragic.com/default/iso/4#!/4
- [x] 會議記錄：http://ttfri.ragic.com/default/forms2/4
- [x] 資料清單：http://ttfri.ragic.com/default/iso/6
- [ ] 個案定義彙整：\\142NAS\Public\14.資料庫\DB-找個案
	+ [ ] 梅雨鋒面 
		+ 定義：
		+ 統計時間：2010-2016
	+ [ ] 午後陣雨 
		+ 定義：
		+ 統計時間：2012-2016
	+ [ ] 寒流 
		+ 定義：
		+ 統計時間：2000-2015

**[回到目錄](#目錄)**

# 3. 主機概況 
* 正式機
	+ Windows Server 2008 R2 Standard SP1 (IP:174)
		- 處理器：Inter(R) Xeon(R) CPU E5-2630 v3 @ 2.4GHz
		- 記憶體：72 GB(僅支援至 32GB)
		- 硬碟：600 GB
	+ SUSE Linux Enterprise Server 12 (IP:178)
		- 處理器：Intel(R) Xeon(R) CPU E5-2630 v3 @ 2.4GHz
		- 記憶體：72 GB
		- 硬碟：13 TB
	+ SQL Server
		- 版本：Microsoft SQL Server 2014 - 12.0.4100.1 (X64) Standard Edition (64-bit)
* 備援機
	+ Windows Server 2012 Standard (IP:177)
		- 處理器：Inter(R) Xeon(R) CPU E5-2620 v2 @ 2.1GHz
		- 記憶體：40 GB
		- 硬碟：600 GB
	+ Linux CentOS release 6.5 (IP:175)
		- 處理器：Intel(R) Xeon(R) CPU E5-2620 v2 @ 2.1GHz
		- 記憶體：40 GB
		- 硬碟：17 TB
	+ SQL Server
		- 版本：Microsoft SQL Server 2012 (SP1) - 11.0.3128.0 (X64)	Standard Edition (64-bit)
* 測試機
	+ Windows Server Server 2008 R2 Standard SP1 (IP:139)
		- 處理器：Inter(R) Xeon(R) CPU E5-2620 v2 @ 2.1GHz
		- 記憶體：40 GB(僅支援至 32GB)
		- 硬碟：560 GB
	+ CentOS release 6.4 (Final) (IP:141)
		- 處理器：Intel(R) Xeon(R) CPU E5-2620 0 @ 2.0GHz
		- 記憶體：40 GB
		- 硬碟：800 GB
	+ SQL Server
		- 版本：Microsoft SQL Server 2012 (SP3-GDR) (KB3194721) - 11.0.6248.0 (X64) Standard Edition (64-bit)

**[回到目錄](#目錄)**


**[回到目錄](#目錄)**
