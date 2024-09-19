<!DOCTYPE HTML>
<html>
<head>
    <title>Анализ</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="container d-flex flex-column min-vh-100">
    <header class="py-3 mb-4 border-bottom">
        <h2 align="center">Анализ файла ${originalFileName}</h2>
    </header>
	<div class="row py-3 mb-4 border-bottom text-center">
      <div class="col-6 themed-grid-col">Размер файла: ${size} байт</div>
      <div class="col-6 themed-grid-col">Количество страниц: ${count} шт.</div>
    </div>
	<div class="row py-3 mb-4 border-bottom text-center">
      <div class="col-6 themed-grid-col">Ширина страницы: ${pageWidth} см.</div>
      <div class="col-6 themed-grid-col">Длина страницы: ${pageHeight} см.</div>
    </div>
	<div class="row py-3 mb-4 border-bottom text-center">
      <div class="col-6 themed-grid-col">Ширина печатной области: ${printWidth} см.</div>
      <div class="col-6 themed-grid-col">Длина печатной области: ${printHeight} см.</div>
    </div>
	<div class="row py-3 mb-4 border-bottom text-center">
      <div class="col-6 themed-grid-col">Ширина заполнения: ${printWidthPercent} %</div>
      <div class="col-6 themed-grid-col">Длина заполнения: ${printHeightPercent} %</div>
    </div>
	<div class="d-grid gap-2 d-md-flex justify-content-between">
	<a href="/home"><button class="btn btn-primary me-md-2" type="button">Назад</button></a>
	<a href="/pdf/read/${pdfId}"><button class="btn btn-primary" type="button">Чтение</button></a>
</div>
	<footer class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between mb-4 border-top mt-auto">
        <span class="text-muted">© 2024 PDF Инструмент</span>
        <span class="text-muted justify-content-end">Климов Артем ПИ-11</span>
    </footer>
</body>
</html>