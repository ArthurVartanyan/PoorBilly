<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500&family=Spectral:wght@800&display=swap" rel="stylesheet">

  <div class="container">
    <div class="row">

      <div class="col-md-offset-3 col-md-6">
        <form class="form-horizontal">
          <span class="heading">Poor Billy project</span>
          <div class="form-group">
            <input type="text" class="form-control" id="inputEmail" placeholder="Login">
            <i class="fa fa-user"></i>
          </div>
          <div class="form-group help">
            <input type="password" class="form-control" id="inputPassword" placeholder="Password">
            <i class="fa fa-lock"></i>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-default"><strong>Login</strong></button>
          </div>
        </form>
      </div>
    </div><!-- /.row -->
  </div><!-- /.container -->
</template>

<script>
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.container {
  margin-top:230px;
}
/* Form Style */
.form-horizontal{
  background: #fff;
  padding-bottom: 40px;
  border-radius: 15px;
  text-align: center;
}
.form-horizontal .heading{
  font-family: 'Spectral', serif;
  line-height: 120px;
  font-weight: normal;
  margin-top: 50px;
  text-align: center;
  color: #30af8f;
  display: block;
  font-size: 65px;
  /*font-weight: 700;*/
  padding: 1px 0;
  border-bottom: 5px solid #f0f0f0;
  margin-bottom: 20px;
  : 100px;
}
.form-horizontal .form-group{
  padding: 0 40px;
  margin: 0 0 25px 0;
  position: relative;
}
.form-horizontal .form-control{
  background: #f0f0f0;
  border: none;
  border-radius: 20px;
  box-shadow: none;
  padding: 0 20px 0 45px;
  height: 40px;
  transition: all 0.3s ease 0s;
}
.form-horizontal .form-control:focus{
  background: #e0e0e0;
  box-shadow: none;
  outline: 0 none;
}
.form-horizontal .form-group i{
  position: absolute;
  top: 12px;
  left: 60px;
  font-size: 17px;
  color: #c8c8c8;
  transition : all 0.5s ease 0s;
}
.form-horizontal .form-control:focus + i{
  color: #30af8f;
}

.form-horizontal .btn{
  float: right;
  font-size: 14px;
  color: #fff;
  background: #30af8f;
  border-radius: 30px;
  padding: 10px 25px;
  border: none;
  text-transform: capitalize;
  transition: all 0.5s ease 0s;
}
@media only screen and (max-width: 479px){
  .form-horizontal .form-group{
    padding: 0 25px;
  }
  .form-horizontal .form-group i{
    left: 45px;
  }
  .form-horizontal .btn{
    padding: 10px 20px;
  }
}
</style>