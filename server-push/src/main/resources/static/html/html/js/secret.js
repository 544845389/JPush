/**
 * Created by 54484 on 2018/4/25.
 */



/**
 * 解密
 */
function  decrypt() {
    var value =  $("#decryptInput").val();
    if(value == "" || value == undefined){
        $("#decryptText").val("解密后的内容");
        return;
    }

    var  params = {
        text:value
    }

    var url = URL +  decryptText;
    comment.post( url  , JSON.stringify(params) , '执行中....', function (res) {
        if(res != null && res != undefined && res.text != ""){
            $("#decryptText").val(res.text);
        }else{
            $("#decryptText").val("解密失败！");
        }
    });

}






/**
 * 加密
 */
function  encrypt() {
    var value =  $("#encryptInput").val();
    if(value == "" || value == undefined){
        $("#encryptText").val("加密后的内容");
        return;
    }

    var  params = {
        text:value
    }

    var url = URL +  encryptText;
    comment.post( url  , JSON.stringify(params) , '执行中....', function (res) {
        if(res != null && res != undefined && res.text != ""){
            $("#encryptText").val(res.text);
        }else{
            $("#encryptText").val("加密失败!");
        }
    });

}
