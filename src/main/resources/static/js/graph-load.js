function loadGraph(axisArrays){
    console.log(axisArrays);

	xArray = axisArrays.xarray;
	yArray = axisArrays.yarray;
	label = axisArrays.label;
	title = axisArrays.name
    console.log(xArray);

    var points = getPoints(xArray, yArray);

    console.log(points);

    var chart = createChart(title, points, label);
    chart.render();
};

function createChart(title, points, label){
    return new CanvasJS.Chart("chartContainer", {
                      title:{
                            text: title
                      },
                      zoomEnabled: true,
                      axisY:{
                       interval: 1,
                       title: "Кол-во человек",
                      },
                       legend:{
                        fontSize: 30,
                        fontFamily: "tamoha",
                        fontColor: "Sienna",
                        horizontalAlign: "center", // left, center ,right
                        verticalAlign: "top",  // top, center, bottom
                       },
                      data: [
                      {
                          type: "column",
                          color: "#42AAFF",
                          dataPoints: points,
                          showInLegend: true,
                          legendText: label,
                      }
                      ],
                       exportEnabled: true
    })
 ;}

function getPoints(xArray, yArray){
    var length = xArray.length;
    var points = [];

    for(i = 0; i < length; i++) {
        xEl = xArray[i];
        yEl = yArray[i];

         points.push({'label': xEl, 'y': yEl})
    }

    return points;
}