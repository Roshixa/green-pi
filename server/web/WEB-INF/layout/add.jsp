<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>GreenAutoBot - Add New Plant</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css"
      />
    <script
      src="https://code.jquery.com/jquery-3.1.1.min.js"
      integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
      crossorigin="anonymous"
      ></script>
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
        <a class="item green active">
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
            <h2 class="ui header dividing center aligned">Add New Plant</h2>
            <form class="ui form" method="post" action="add">
              <div class="field">
                <label>Plant Name</label>
                <div class="ui left icon input">
                  <input name="name" type="text" placeholder="Plant Name" />
                  <i class="bookmark outline icon"></i>
                </div>
              </div>
              <div class="field">
                <label>Server Address</label>
                <div class="ui left icon input">
                  <input name="dbAddress" type="text" placeholder="Server Address" />
                  <i class="globe icon"></i>
                </div>
              </div>
              <div class="field">
                <label>Server Port</label>
                <div class="ui left icon input">
                  <input name="port" type="number" placeholder="3306" value="3306"/>
                  <i class="globe icon"></i>
                </div>
              </div>
              <div class="field">
                <label>Database Username</label>
                <div class="ui left icon input">
                  <input name="dbUsername" type="text" placeholder="Database Username" />
                  <i class="user icon"></i>
                </div>
              </div>
              <div class="field">
                <label>Database Password</label>
                <div class="ui left icon input">
                  <input name="dbPassword" type="password" placeholder="Database Password" />
                  <i class="lock icon"></i>
                </div>
              </div>
              <div class="field">
                <label>Description</label>
                <div class="ui left icon input">
                  <textarea name="description" placeholder="Description"></textarea>
                  <i class="file alternate outline icon"></i>
                </div>
              </div>
              <button type="submit" class="ui green submit button">
              <i class="plus icon"></i>Add
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
      $(document).ready(function() {
        $(".ui.menu .ui.dropdown").dropdown({
          on: "hover"
        });
      });
    </script>
  </body>
</html>