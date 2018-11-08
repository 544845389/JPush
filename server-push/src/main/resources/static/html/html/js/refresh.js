/**
 * Created by 54484 on 2018/4/25.
 */


/**
 * 刷新全部
 */
$("#refreshAll").on('click',  function() {

    var url = URL +  busRefreshAll;
    comment.post( url  , null , '执行中....', function (res) {
        if(res != null && res != undefined && res == 1 ){
            hint('配置刷新成功！');
        }else{
            hint('配置刷新失败！');
        }
    });

})






/**
 * 刷新部分
 */
$("#refresh").on('click',  function() {
    var name =  $("#ApplicationName").val();
    if(name == "" || name == undefined || name == null){
        hint('项目ApplicationName不可为空！');
        return;
    }

    var port =  $("#port").val();
    if(port == "" || port == undefined || port == null){
        hint('项目端口号不可为空！');
        return;
    }

    var param = {
        name:name,
        port:port
    }

    var url = URL + busRefresh;
    comment.post(url, JSON.stringify(param), '执行中....', function (res) {
        if (res != null && res != undefined && res == 1) {
            hint('配置刷新成功！');
        } else {
            hint('配置刷新失败！');
        }
    });
});


