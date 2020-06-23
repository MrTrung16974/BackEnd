//Sap xep voi dd/MM/yyyy hh:mm:ss
jQuery.extend(jQuery.fn.dataTableExt.oSort, {
    "datetime-pre": function (a) {
        if (a == null || a == "") {
            return 0;
        }
        var dateArr = a.split(" ")[0].split("/");
        var timeArr = a.split(" ")[1].split(":");
        var value = dateArr[2] + dateArr[1] + dateArr[0] + timeArr[0] + timeArr[1] + timeArr[2];
        return parseInt(value);
    },

    "datetime-asc": function (a, b) {
        return ((a < b) ? -1 : ((a > b) ? 1 : 0));
    },

    "datetime-desc": function (a, b) {
        return ((a < b) ? 1 : ((a > b) ? -1 : 0));
    }
});