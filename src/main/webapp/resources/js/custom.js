
$('#calendar').datepicker({}).bind(
    'click',
    function()
    {
        $('document').ready(function () {
            var monthAndYear = $('div.datepicker.datepicker-inline')
                .children('div.datepicker-days')
                .children('table.table-condensed')
                .children('thead')
                .children('tr')
                .children('th.datepicker-switch');

            var split = monthAndYear.text().split(" ");
            var year = split[1];
            var month = split[0];

            var day = $('div.datepicker.datepicker-inline')
                .children('div.datepicker-days')
                .children('table.table-condensed')
                .children('tbody')
                .children('tr')
                .children('td.active');
            var dayInt = parseInt(day.text());

            if (isNaN(dayInt)) {
                return;
            } else {
                window.location.replace("http://"+window.location.host+"/panel/schedule/"+year+"/"+month+"/"+dayInt.toString());
            }

        });

    }
);


!function ($) {
    $(document).on("click", "ul.nav li.parent > a ", function () {
        $(this).find('em').toggleClass("fa-minus");
    });
    $(".sidebar span.icon").find('em:first').addClass("fa-plus");
}

(window.jQuery);
$(window).on('resize', function () {
    if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
})
$(window).on('resize', function () {
    if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
})

$(document).on('click', '.panel-heading span.clickable', function (e) {
    var $this = $(this);
    if (!$this.hasClass('panel-collapsed')) {
        $this.parents('.panel').find('.panel-body').slideUp();
        $this.addClass('panel-collapsed');
        $this.find('em').removeClass('fa-toggle-up').addClass('fa-toggle-down');
    } else {
        $this.parents('.panel').find('.panel-body').slideDown();
        $this.removeClass('panel-collapsed');
        $this.find('em').removeClass('fa-toggle-down').addClass('fa-toggle-up');
    }
});



