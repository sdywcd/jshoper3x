$(document).ready(function () {
    $("#dialog").dialog({
        autoOpen: false
    });

    $("#dialog-open").click(function () {
        $("#dialog").dialog("open");
        return false;
    });

    $("#dialog-modal").dialog({
        autoOpen: false,
        height: 140,
        modal: true
    });

    $("#dialog-modal-open").click(function () {
        $("#dialog-modal").dialog("open");
        return false;
    });

    $("#dialog-message").dialog({
        autoOpen: false,
        modal: true,
        buttons: {
            Ok: function () {
                $(this).dialog('close');
            }
        }
    });

    $("#dialog-message-open").click(function () {
        $("#dialog-message").dialog("open");
        return false;
    });

    $("#dialog-confirm").dialog({
        autoOpen: false,
        resizable: false,
        height: 140,
        modal: true,
        buttons: {
            'Delete all items': function () {
                $(this).dialog('close');
            },
            Cancel: function () {
                $(this).dialog('close');
            }
        }
    });

    $("#dialog-confirm-open").click(function () {
        $("#dialog-confirm").dialog("open");
        return false;
    });

    $("#dialog-form").dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true,
        buttons: {
            'Create an account': function () {
                $(this).dialog('close');
            },
            Cancel: function () {
                $(this).dialog('close');
            }
        },
        close: function () {
            allFields.val('').removeClass('ui-state-error');
        }
    });

    $("#dialog-form-open").click(function () {
        $("#dialog-form").dialog("open");
        return false;
    });
});