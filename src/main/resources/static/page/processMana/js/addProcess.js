/**
 * Created by caiyl on 2017/10/8.
 */
function save() {
    var data = $("form").serializeArray()
    $.post('/models/newModel',data,function (dat) {
        if (dat.successFlag) {
            parent.layer.open({
                type: 2,
                title: '新增流程',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['100%', '100%'],
                offset: 't',
                content: '/modeler.html?modelId='+dat.message
            });
        }
    })
}