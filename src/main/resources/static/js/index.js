/**
 * Created by caiyl on 2017/10/8.
 */
$(function () {

    var tool = [];

    tool.push({
        text: '新增流程', iconCls: 'fa fa-plus icolor', btnCls: 'btn jqgrid-tool-btn', handler: function () {
            AJAX.POST('/models/newModel')
        }
    });
    tool.push({
        text: '批量删除', iconCls: 'fa fa-plus icolor', btnCls: 'btn jqgrid-tool-btn', handler: function () {
        }
    });

    $("#jqGridList").jqGrid({
        url: "../process/models",
        datatype: "json",
        mtype: "GET",
        styleUI: 'Bootstrap',
        toolbar: [true, "top", tool],
        colNames: ["流程id", "流程名称", "版本", "流程key值", "是否已部署", "创建时间","更新时间"],
        colModel: [
            { name: "id", width: 55 },
            { name: "name", width: 90 },
            { name: "version", width: 80, align: "right" },
            { name: "key", width: 80, align: "right" },
            { name: "name", width: 80, align: "right" },
            { name: "createTime", width: 150, align: "right" ,formatter:function(cellvalue, options, rowObject) {
                return Utils.formatDate(cellvalue)
            }},
            { name: "lastUpdateTime", width: 150, align: "right" ,formatter:function(cellvalue, options, rowObject) {
                return Utils.formatDate(cellvalue)
            }}
        ],
        pager: "#jqGridPager",
        rowNum: 10,
        rowList: [10, 20, 30],
        viewrecords: true,
        height: "100%",
        autowidth: true
    });


});