


var bLogin = 0;

function init(){

	var params = location.search.substr(1); 
	var size = GetQueryString("size");
	var numbers = GetQueryString("numbers");
	var type = GetQueryString("type");
	
	//size = 1;
	//numbers = "1000243$1$0$0";
	
	if(size<1||numbers=="")
	{
		alert("当前工程未添加摄像头。");
	}else
	{
		 var obj = document.getElementById("DPSDK_OCX");
		 
		 
		 
    	 gWndId = obj.DPSDK_CreateSmartWnd(0, 0, 100, 100);
   	 	 ButtonCreateWnd_onclick(size);
         ButtonLogin_onclick(numbers,size,type);
	}
}



function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}




function ButtonCreateWnd_onclick(size)
{
    var obj = document.getElementById("DPSDK_OCX");
    var nWndCount = size;
    obj.DPSDK_SetWndCount(gWndId, nWndCount);
    obj.DPSDK_SetSelWnd(gWndId, 0);
}


/**
 * 登录
 * @constructor
 */
function ButtonLogin_onclick(numbers,size,type)
{
    var obj = document.getElementById("DPSDK_OCX");
    var result = -1;
    if(type == 1){
     result = obj.DPSDK_Login("58.214.39.114", "9000", "智慧工地", "1234567");
    }else if(type == 2){
     result = obj.DPSDK_Login("221.131.121.62", "9000", "yxjz", "yxjz2017");
    }
    if (result == 0)
    {
        //成功,TODO……
        bLogin = 1;
        
        var cameraNumbers =  new Array(); 
        
        if(numbers.indexOf(",")!=-1)
        {
        	cameraNumbers = numbers.split(",");
        }else
        {
        	cameraNumbers[0] = numbers;
        }
        
        for(var i=0;i<size;i++)
        {
        	 Button_DirectRealplayByWndNo_onclick(cameraNumbers[i],i);
        }
    }
    else
    {
        //失败打印错误码,TODO……

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
        var nWndNo = obj.DPSDK_GetSelWnd(gWndId);
        // 开始预览
        var nResult = obj.DPSDK_DirectRealplayByWndNo(gWndId, index, strCameraId, 1, 1, 1);
        if(nResult == 0)
        {
            // 成功
        }
        else
        {
            // 失败
        }

    }



