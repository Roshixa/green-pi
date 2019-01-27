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
            <a class="item" href="live/<c:out value="${plant.hash}"/>"><c:out value="${plant.name}"/></a>
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
        <h2 class="ui header dividing center aligned">Monitoring:<c:out value="${plant.name}"/></h2>
        <p class="ui paragraph"><c:out value="${plant.description}"/></p>

        <div class="ui container">
        <h3 class="ui header dividing center aligned">Temperature Graph</h3>
        <p class="ui paragraph">...</p>
        </div>
        <div class="ui container">
        <h3 class="ui header dividing center aligned">Luminosity Graph</h3>
        <p class="ui paragraph">...</p>
        </div>
        <div class="ui container">
        <h3 class="ui header dividing center aligned">Humidity Graph</h3>
        <p class="ui paragraph">...</p>
        </div>
        <div class="ui container">
        <h3 class="ui header dividing center aligned">Moisture Graph</h3>
        <p class="ui paragraph">...</p>
        </div>
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
        </script>
        </body>
        </html>