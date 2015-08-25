$(function () {
    $("#radio_used").click(function () {
        $("#howOld").css('display', 'block');
        return true;
    });
    $("#radio_new").click(function () {
        $("#howOld").css('display', 'none');
        return true;
    });

    $("#radio_byBuyer").click(function () {
        $("#yunfei").css('display', 'inline');
        return true;
    });
    $("#radio_bySeller").click(function () {
        $("#yunfei").css('display', 'none');
        return true;
    });
});

