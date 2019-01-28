<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>GreenAutoBot - Live Monitoring</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css"
      />
    <script
      src="https://code.jquery.com/jquery-3.1.1.min.js"
      integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
      crossorigin="anonymous" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/series-label.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
  </head>
  <body>
    <br />
    <div class="ui container green aligned center">
      <h1 class="ui header green center aligned">Welcome to GreenAutoBot!</h1>
    </div>
    <br />
    <div class="ui container grid">
      <div class="ui secondary vertical menu four wide column">
        <a class="item" href="add">
        <i class="plus icon"></i> Add
        </a>
        <a class="item" href="stats">
        <i class="chart line icon"></i> Plants Statuses
        </a>
        <div class="ui dropdown item green" tabindex="0">
          <i class="dropdown icon"></i>
          Monitor Live
          <div class="menu">
            <div class="header">Plants</div>
            <c:forEach var="plant" items="${plants}">
              <a class="item" href="live/<c:out value="${plant.hash}"/>">
              <c:out value="${plant.name}"/>
              </a>
            </c:forEach>
          </div>
        </div>
        <a class="item active red" href="logout">
        <i class="sign-out icon"></i> Logout
        </a>
      </div>
      <div class="ui placeholder segment twelve wide column">
        <div class="ui very relaxed stackable grid">
          <div class="column">
            <h2 class="ui header dividing center aligned">
              Monitoring:
              <c:out value="${plant.name}"/>
            </h2>
            <p class="ui paragraph">
              <c:out value="${plant.description}"/>
            </p>
            
            <div class="ui container" id="graphs-t"></div>
            <div class="ui container" id="graphs-m"></div>
            <div class="ui container" id="graphs-l"></div>
            <div class="ui container" id="graphs-h"></div>
            
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
      $(document).ready(function() {
      $('.ui.menu .ui.dropdown').dropdown({
          on: 'hover'
        });
      });
      var plant = '<c:out value="${plant.hash}"/>';

      function draw() {
        $.getJSON("../readings/" + plant, function(data) {
          Highcharts.chart('graphs-t', {
            title: {
              text: 'Temperature Readings'
            },
            yAxis: {
              title: {
                text: 'Values'
              }
            },
            legend: {
              layout: 'vertical',
              align: 'right',
              verticalAlign: 'middle'
            },
            chart: {
              animation: false
            },
            plotOptions: {
              series: {
                label: {
                  connectorAllowed: false
                },
                animation: false
              },
              line: {
                animation: false
              }
            },
            series: [{
              name: 'Temperature',
              data: data.temperature
            }],
            responsive: {
              rules: [{
                condition: {
                  maxWidth: 500
                },
                chartOptions: {
                  legend: {
                    layout: 'horizontal',
                    align: 'center',
                    verticalAlign: 'bottom'
                  }
                }
              }]
            }
          });
          Highcharts.chart('graphs-m', {
            title: {
              text: 'Moisture Readings'
            },
            yAxis: {
              title: {
                text: 'Values'
              }
            },
            legend: {
              layout: 'vertical',
              align: 'right',
              verticalAlign: 'middle'
            },
            chart: {
              animation: false
            },
            plotOptions: {
              series: {
                label: {
                  connectorAllowed: false
                },
                animation: false
              },
              line: {
                animation: false
              }
            },
            series: [{
              name: 'Moisture',
              data: data.moisture
            }],
            responsive: {
              rules: [{
                condition: {
                  maxWidth: 500
                },
                chartOptions: {
                  legend: {
                    layout: 'horizontal',
                    align: 'center',
                    verticalAlign: 'bottom'
                  }
                }
              }]
            }
          });
          Highcharts.chart('graphs-l', {
            title: {
              text: 'Luminosity Readings'
            },
            yAxis: {
              title: {
                text: 'Values'
              }
            },
            legend: {
              layout: 'vertical',
              align: 'right',
              verticalAlign: 'middle'
            },
            chart: {
              animation: false
            },
            plotOptions: {
              series: {
                label: {
                  connectorAllowed: false
                },
                animation: false
              },
              line: {
                animation: false
              }
            },
            series: [{
              name: 'Luminosity',
              data: data.luminosity
            }],
            responsive: {
              rules: [{
                condition: {
                  maxWidth: 500
                },
                chartOptions: {
                  legend: {
                    layout: 'horizontal',
                    align: 'center',
                    verticalAlign: 'bottom'
                  }
                }
              }]
            }
          });
          Highcharts.chart('graphs-h', {
            title: {
              text: 'Humidity Readings'
            },
            yAxis: {
              title: {
                text: 'Values'
              }
            },
            legend: {
              layout: 'vertical',
              align: 'right',
              verticalAlign: 'middle'
            },
            chart: {
              animation: false
            },
            plotOptions: {
              series: {
                label: {
                  connectorAllowed: false
                },
                animation: false
              },
              line: {
                animation: false
              }
            },
            series: [{
              name: 'Humidity',
              data: data.humidity
            }],
            responsive: {
              rules: [{
                condition: {
                  maxWidth: 500
                },
                chartOptions: {
                  legend: {
                    layout: 'horizontal',
                    align: 'center',
                    verticalAlign: 'bottom'
                  }
                }
              }]
            }
          });
        });
      }

      function run() {
        draw();
        setTimeout(run, 2000);
      }
      run();
    </script>
  </body>
</html>