<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sm-12">
    <p class="back-link">Website by <a href="https://github.com/Cutter72">Cutter72</a> and <a href="https://github.com/Blu911">Blu911</a></p>
</div>
</div><!--/.row-->
</div>    <!--/.main-->

<script src="../../../resources/js/jquery-1.11.1.min.js"></script>
<script src="../../../resources/js/bootstrap.min.js"></script>
<script src="../../../resources/js/chart.min.js"></script>
<script src="../../../resources/js/chart-data.js"></script>
<script src="../../../resources/js/easypiechart.js"></script>
<script src="../../../resources/js/easypiechart-data.js"></script>
<script src="../../../resources/js/bootstrap-datepicker.js"></script>
<script src="../../../resources/js/custom.js"></script>
<script>
    window.onload = function () {
        var chart1 = document.getElementById("line-chart").getContext("2d");
        window.myLine = new Chart(chart1).Line(lineChartData, {
            responsive: true,
            scaleLineColor: "rgba(0,0,0,.2)",
            scaleGridLineColor: "rgba(0,0,0,.05)",
            scaleFontColor: "#c5c7cc"
        });
    };
</script>

</body>
</html>