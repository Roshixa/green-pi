<%@ page contentType="text/html;charset=UTF-8" %> <!DOCTYPE html>
<html>
  <head>
    <title>GreenAutoBot - Login</title>
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
    <style type="text/css">
      .ui.container {
        margin-top: 50px;
      }
    </style>
  </head>
  <body>
    <div class="ui container padded">
      <h1 class="ui header dividing center aligned green">
        Welcome to GreenAutoBot!
      </h1>
      <div class="ui placeholder segment">
        <div class="ui two column very relaxed stackable grid">
          <div class="column">
            <h2 class="ui header dividing center aligned">Login</h2>
            <form class="ui form" method="post" action="login">
              <div class="field">
                <label>Email</label>
                <div class="ui left icon input">
                  <input name="email" type="email" placeholder="Email" />
                  <i class="at icon"></i>
                </div>
              </div>
              <div class="field">
                <label>Password</label>
                <div class="ui left icon input">
                  <input
                    name="password"
                    type="password"
                    placeholder="Password"
                  />
                  <i class="lock icon"></i>
                </div>
              </div>
              <button type="submit" class="ui green submit button">
                Login
              </button>
            </form>
          </div>
          <div class="middle aligned column">
            <h2 class="ui header dividing center aligned">Signup</h2>
            <form class="ui form" method="post" action="login">
              <div class="field">
                <label>Complete Name</label>
                <div class="ui left icon input">
                  <input name="name" type="text" placeholder="Complete Name" />
                  <i class="user icon"></i>
                </div>
              </div>
              <div class="field">
                <label>Email</label>
                <div class="ui left icon input">
                  <input name="email" type="email" placeholder="Email" />
                  <i class="at icon"></i>
                </div>
              </div>
              <div class="field">
                <label>Password</label>
                <div class="ui left icon input">
                  <input
                    name="password"
                    type="password"
                    placeholder="Password"
                  />
                  <i class="lock icon"></i>
                </div>
              </div>
              <div class="field">
                <label>Password Confirmation</label>
                <div class="ui left icon input">
                  <input
                    name="password_confirmation"
                    type="password"
                    placeholder="Password Confirmation"
                  />
                  <i class="lock icon"></i>
                </div>
              </div>
              <button type="submit" class="ui green submit button">
                Login
              </button>
            </form>
          </div>
        </div>
        <div class="ui vertical divider">Or</div>
      </div>
    </div>
  </body>
</html>
