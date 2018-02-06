/**
 * Created by caiyl on 2017/10/8.
 */
$(function () {

    var tool = [];

    tool.push({
        text: '新增', iconCls: 'fa fa-plus icolor', btnCls: 'btn jqgrid-tool-btn', handler: function () {
            // AJAX.POST('/models/newModel')
            //iframe窗
            layer.open({
                type: 2,
                title: '新增',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['80%', '60%'],
                offset: 't',
                content: ['/page/userMana/addUser.html','no']
            });
        }
    });


    $("#jqGridList").jqGrid({
        url: "/users/",
        datatype: "json",
        mtype: "GET",
        styleUI: 'Bootstrap',
        toolbar: [true, "top", tool],
        colNames: ["序号", "账号", "用户名", "性别", "密码"],
        colModel: [
            { name: "id", width: 55,align: "center" },
            { name: "userName", width: 90 ,align: "center"},
            { name: "userNameCN", width: 80, align: "center" },
            { name: "userSex", width: 80, align: "center" },
            { name: "password", width: 80, align: "center" }

        ],
        pager: "#jqGridPager",
        rowNum: 10,
        rowList: [10, 20, 30],
        viewrecords: true,
        height: "500",
        autowidth: true
    });

});

function search() {
    $("#jqGridList").jqGrid('setGridParam', {
        mtype: 'POST',
        url: '/process/models',
        page:1,
        datatype: "json"
    }).trigger("reloadGrid");
};

function delModel(id) {
    //询问框
    layer.confirm('是否删除该模型？', {
        btn: ['是','否'] //按钮
    }, function(){

        $.ajax({
            url:"/models/"+id,
            type:'delete',
            dataType:"json",
            data:null,
            success:function(result){
                layer.msg("删除成功");
                search();
            }

        })

    }, function(){


    });
}

function edit(id) {
    layer.open({
        type: 2,
        title: '编辑流程',
        shadeClose: true,
        shade: false,
        maxmin: true, //开启最大化最小化按钮
        area: ['100%', '100%'],
        offset: 't',
        content: '/modeler.html?modelId='+id
    });
}
function publish(id) {

    //询问框
    layer.confirm('是否发布该模型？', {
        btn: ['是','否'] //按钮
    }, function(){

        $.ajax({
            url:"/models/"+id+"/deployment",
            type:'post',
            dataType:"json",
            data:null,
            success:function(result){
                layer.msg("发布成功");
                search();
            }

        })

    }, function(){


    });
}