/**
 * Created by 54484 on 2018/4/23.
 */




/**
 * 下载云配置文件
 */
$("#downCloudConfig-button").on('click',  function() {
    modal.modal('hide');
    var url = URL +  downloadConfig;
    comment.post( url  , null , '执行中....', function (res) {
        if (res == 1) {
           hint('下载成功！');

        }else{
           hint('下载失败！')
        }
    });
})
