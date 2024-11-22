<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Talent Management X"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,200;0,400;1,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />


    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/stock/modules/exporting.js"></script>

</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light fixed-top bg-light">
        <a class="navbar-brand" href="/">TalentManagement X</a>
        %{--Member Action Menu--}%
        <ul class="navbar-nav ml-auto" style="margin-left: 44rem;">
            <UIHelper:memberActionMenu/>
        </ul> &nbsp; &nbsp; &nbsp; &nbsp;
%{--        <g:link controller="authentication" action="logout" class="mr-auto"><i--}%
%{--                class="fas fa-right-from-bracket">&nbsp;</i>Logout</g:link>--}%
        <g:link controller="authentication" action="logout" class="mr-auto">
            <i class="fas fa-right-from-bracket">&nbsp;</i>Logout</g:link>

    </nav>
</header>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-2 col-md-2 d-none d-sm-block bg-light sidebar" style="margin-top: 4rem !important;">
            <ul class="list-group">
                <UIHelper:rightNavigation/>
            </ul>
        </nav>


        <main role="main" class="col-lg-9 ml-auto col-md-10 pt-3" style="padding-left:21rem; margin-top: 4rem;">
            <g:layoutBody/>
        </main>
    </div>
</div>

<footer class="bottom-footer">
    &copy Copyright 2023 - Employee Management System. | All rights reserved. Ver. 1.0.0
</footer>

</body>
</html>
