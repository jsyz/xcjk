var bLogin = 0;
var type = 0;
var coding = "";
var projectName = "";
var obj = null;
var windowId = 0;
var numbers =  new Array(); 

function init(){

	type = GetQueryString("type");
	size = GetQueryString("size");
	projectName = GetQueryString("projectName");
	
	//step1:创建OCX控件
	obj = document.getElementById("DPSDK_OCX");
	 
	//step2:登录平台
	type = 2;
	var loginResult = login();
	//step:加载组织设备
	var loadDGropInfoResult=obj.DPSDK_LoadDGroupInfo();
	
	setNumbers(projectName,loadXMLDoc(obj.DPSDK_GetDGroupStr()));
	 
	windowId = obj.DPSDK_CreateSmartWnd(0, 0, 100, 100);
 	createWindow(size);
    loadNumbers(numbers);
	       
}

function setNumbers(projectName,xmldoc)
{
	var elements = xmlDoc.getElementsByTagName("Department");

	for (var i = 0; i < elements.length; i++) {
	
		if(elements[i].attributes.getNamedItem("name").nodeValue == projectName) 
		{
			var sunElements = elements[i].getElementsByTagName("Channel");
			
			for(var j = 0; j < sunElements.length; j++)
			{
				numbers.push(sunElements[j].attributes.getNamedItem("id").nodeValue);
			}
		}
	}

}

function login()
{
	var result = -1;
	
    if(type == 1){
     result = obj.DPSDK_Login("58.214.39.114", "9000", "智慧工地", "1234567");
    }else if(type == 2){
     result = obj.DPSDK_Login("221.131.121.62", "9000", "yxjz", "yxjz2017");
    }
    
    if (result == 0)
    {
        //成功,TODO……
    }
    else
    {
        return;
    }
	return result;
}



function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}


function createWindow(size)
{
    var obj = document.getElementById("DPSDK_OCX");
    obj.DPSDK_SetWndCount(windowId, size);
    obj.DPSDK_SetSelWnd(windowId, 0);
}


function loadNumbers(numbers)
{
    for(var i=0;i<numbers.length;i++)
    {
    	Button_DirectRealplayByWndNo_onclick(numbers[i],i);
    }
}


/**
 * 播放视频
 * @constructor
 */
function ButtonStartRealplayByWndNo_onclick()
{
    var obj = document.getElementById("DPSDK_OCX");

    var szCameraId = document.getElementById("textCameraID").value;
    var nStreamType = document.getElementById("selectStreamType").value;
    var nMediaType = document.getElementById("selectMediaType").value;
    var nTransType = document.getElementById("selectTransType").value;

    var nWndNo = obj.DPSDK_GetSelWnd(gWndId);
    var nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, nWndNo, szCameraId, nStreamType, nMediaType, nTransType);
    ShowCallRetInfo(nRet, "播放视频");
    if(nRet == 0)
    {
        insertRealplayHistory(szCameraId);
        ShowCallRetInfo(obj.DPSDK_SetIvsShowFlagByWndNo(gWndId, nWndNo, 1, bIVS),"规则线显示");//打开规则线显示
        ShowCallRetInfo(obj.DPSDK_SetIvsShowFlagByWndNo(gWndId, nWndNo, 2, bIVS),"目标框显示");//打开目标框显示
        ShowCallRetInfo(obj.DPSDK_SetIvsShowFlagByWndNo(gWndId, nWndNo, 3, bIVS),"轨迹线显示");//打开轨迹线显示
    }
}


function ButtonLogout_onclick()
{
    var obj = document.getElementById("DPSDK_OCX");
    if( bLogin == 1)
    {
        ShowCallRetInfo(obj.DPSDK_Logout(), "登出");
        bLogin = 0;
    }
}


function ButtonStopRealplayByWndNo_onclick()
{
    var obj = document.getElementById("DPSDK_OCX");

    var nWndNo = obj.DPSDK_GetSelWnd(gWndId);
    ShowCallRetInfo(obj.DPSDK_StopRealplayByWndNo(gWndId, nWndNo), "停止播放视频");
}


/**
 *　根据窗口号启动实时浏览(无需提前加载组织结构)
 * @constructor
 */
function Button_DirectRealplayByWndNo_onclick(strCameraId,index){

		
			
        // 获取ocx实例
        var obj = document.getElementById("DPSDK_OCX");
        // 设备id
        var strCameraId = strCameraId;
        // 获取当前活动窗口号,其中m_nSmartWndId是由DPSDK_CreateSmartWnd创建的窗口控件id
        var nWndNo = obj.DPSDK_GetSelWnd(windowId);
        // 开始预览
        var nResult = obj.DPSDK_DirectRealplayByWndNo(windowId, index, strCameraId, 1, 1, 1);
        if(nResult == 0)
        {
            // 成功
        }
        else
        {
            // 失败
        }

    }

function loadXMLDoc(text) 
{

try //Internet Explorer
  {
  xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
  xmlDoc.async="false";
  xmlDoc.loadXML(text);
  return xmlDoc;
  }
catch(e)
  {
  try //Firefox, Mozilla, Opera, etc.
    {
    parser=new DOMParser();
    xmlDoc=parser.parseFromString(text,"text/xml");
    return  xmlDoc;
    }
  catch(e) {
	  alert(e.message)
	  }
  }
}
