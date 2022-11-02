function loadGraph(axisArrays){
    console.log(axisArrays);

	xArray = axisArrays.xarray;
	yArray = axisArrays.yarray;
	title = axisArrays.name
    console.log(xArray);

    var points = getPoints(xArray, yArray);

    console.log(points);

    var chart = createChart(title, points);
    chart.render();
};

function createChart(title, points){
    return new CanvasJS.Chart("chartContainer", {
                      title:{
                            text: title
                      },
                      zoomEnabled: true,
                      axisY:{
                       interval: 1,
                       title: "Кол-во человек",
                      },
                      data: [
                      {
                          type: "column",
                          color: "#42AAFF",
                          dataPoints: points
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