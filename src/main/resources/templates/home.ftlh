<!DOCTYPE HTML>
<html>
<head>
    <title>Главная страница</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="container d-flex flex-column min-vh-100">
<header class="py-3 mb-4 border-bottom">
    <h2 align="center">PDF-Инструмент</h2>
    <h3 align="center">Полностью бесплатный онлайн-инструмент для анализа и чтения PDF-файлов.</h3>
</header>
<#if errorMessage??>
<p align="center" style="color: red">${errorMessage}</p>
<#else>
<p class="user-select-none opacity-0">.</p>
</#if>
    <form action="/home/submit" method="post" enctype="multipart/form-data" class="d-grid gap-2 col-4 mx-auto">
          <input required type="file" name="filePDF" class="form-control">
      <div class="d-flex justify-content-between align-items-center">
        <div class="form-check">
            <input type="checkbox" name="save" class="form-check-input" id="same-address" wfd-id="id8">
            <label class="form-check-label" for="same-address">Сохранить</label>
        </div>
        <button type="submit" class="btn btn-outline-success">Анализ</button>
      </div>
    </form>
    <br><br>
    <div class="container">
        <#list files as file>
            <div class="row">
                <div class="col-6 text-center">${file.originalFileName}</div>
                <div class="col text-end"><a href="/pdf/analize/${file.id}"><button class="btn btn-outline-success" type="button">Анализ</button></a></div>
                <div class="col">
                <form action="/delete/${file.id}" method="post">
                <button class="btn btn-outline-danger" type="submit">Удалить</button>
                </form>
                </div>
            </div>
            <br>
        </#list>
    </div>
    <footer class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between mb-4 border-top mt-auto">
        <span class="text-muted">© 2024 PDF Инструмент</span>
        <span class="text-muted justify-content-end">Климов Артем ПИ-11</span>
    </footer>
</body>
</html>