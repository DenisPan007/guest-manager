function loadGraph(axisArrays){
    console.log(axisArrays);

	xArray = axisArrays.xarray;
	yArray = axisArrays.yarray
console.log(xArray);

        const ctx = document.getElementById('histogram').getContext('2d');

const chart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: xArray,
    datasets: [{
      label: 'Number of Arrivals',
      data: yArray,
      backgroundColor: 'blue',
    }]
  },
  options: {
    scales: {
      xAxes: [{
        display: false,
        barPercentage: 1.3,
        ticks: {
          max: 3,
        }
      }, {
        display: true,
        ticks: {
          autoSkip: false,
          max: 4,
        }
      }],
      yAxes: [{
        ticks: {
          beginAtZero: true
        }
      }]
    }
  }
});
};