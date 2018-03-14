$(function () {
    $("#startTime").datepicker({
        autoclose: true,
        todayHighlight: true,
        language:"zh-CN",
        format:"yyyy-mm-dd"
    });
    $("#endTime").datepicker({
        autoclose: true,
        todayHighlight: true,
        language:"zh-CN",
        format:"yyyy-mm-dd"
    });
    
});

/**
 * 发起请假申请
 */
function applyLeave() {
    var data = $("form").serializeArray()
    $.post('/leave/',data,function (dat) {
        if (dat == 0) {
            layer.msg('保存成功', function(){
                closeLayer();
            });
        }else{
            layer.msg('保存失败');
        }
    })
}
