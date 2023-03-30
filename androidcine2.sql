-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-03-2023 a las 12:30:46
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `androidcine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE TABLE `cine` (
  `idCine` int(4) NOT NULL,
  `nombre` varchar(40) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `capacidad` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cine`
--

INSERT INTO `cine` (`idCine`, `nombre`, `direccion`, `capacidad`) VALUES
(1, 'Cines Palafox', 'Calle Independencia 12, CP50004', 300),
(2, 'Cinesa Grancasa', 'Calle María Zambrano 35, CP50015', 250),
(3, 'Aragonia', 'Avenida Juan Carlos I 44, CP50009', 250),
(4, 'Artesiete La Torre', 'Autovía de Logroño 6/5, CP50011', 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `idEntrada` int(4) NOT NULL,
  `precio` decimal(4,2) DEFAULT NULL,
  `idSala` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`idEntrada`, `precio`, `idSala`) VALUES
(1, '4.00', 2),
(2, '2.00', 1),
(3, '3.00', 3),
(4, '2.00', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `idPelicula` int(4) NOT NULL,
  `titulo` varchar(40) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `sinopsis` varchar(250) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `categoria` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `trailer` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `edadRecomendada` int(2) DEFAULT NULL,
  `visualizaciones` int(5) DEFAULT NULL,
  `valoracion` decimal(4,2) DEFAULT NULL,
  `vecesValorada` int(4) DEFAULT NULL,
  `duracion` int(4) DEFAULT NULL,
  `imagen` varchar(200) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`idPelicula`, `titulo`, `sinopsis`, `categoria`, `trailer`, `edadRecomendada`, `visualizaciones`, `valoracion`, `vecesValorada`, `duracion`, `imagen`) VALUES
(1, 'El Gato con Botas: El último deseo', 'El Gato con Botas descubre que su pasión por la aventura le ha pasado factura: ha consumido ocho de sus nueve vidas.', 'Aventuras', 'https://www.youtube.com/watch?v=18v5EPO5ySs', 0, 350, '4.20', 100, 103, 'https://drive.google.com/file/d/1hPz6y3KrYlvG_foNRX-wOXtNvP4oe5cJ/view?usp=sharing'),
(2, 'Todo a la vez en todas partes', 'Cuando una ruptura interdimensional altera la realidad, Evelyn, se ve envuelta en una aventura salvaje en la que sólo ella puede salvar el mundo.', 'Accion', 'https://youtu.be/U3cKYWgl2dU', 16, 400, '4.00', 150, 137, 'https://drive.google.com/file/d/18hJ2l2i3vkE86scmsCXVCvQ1gmxWXJtM/view?usp=sharing'),
(3, 'Avatar: El sentido del agua', 'Ambientada más de una década después de los acontecimientos de la primera película, empieza contando la historia de la familia Sully y sus problemas.', 'Ciencia Ficcion', 'https://youtu.be/FSyWAxUg3Go', 7, 200, '3.85', 150, 192, 'https://drive.google.com/file/d/12LBcH1GKTv6_nZ34ciLMbjMWtCY8ukP8/view?usp=sharing'),
(4, 'La comunidad del anillo', 'Un hobbit llamado Frodo Bolsón hereda de su tío el anillo único, un arma de poder inimaginable', 'Aventuras', 'https://www.youtube.com/watch?v=V75dMMIW2B4', 12, 500, '4.80', 400, 178, 'https://drive.google.com/file/d/1AxOe4vo1ECn3gBfnBtOA7qCx8r3ILoPc/view?usp=sharing'),
(5, 'Harry Potter y la Piedra Filosofal', 'Un niño aprende que es un mago y se une a una escuela de magia, donde se enfrenta a un malvado mago y sus secuaces', 'Fantasía', 'https://www.youtube.com/watch?v=VyHV0BRtdxo', 7, 150, '4.50', 100, 152, 'https://drive.google.com/file/d/1XLXjovRmhsjZSXoYToVZP-b_QY72hD3b/view?usp=sharing'),
(6, 'Titanic', 'Una historia de amor entre dos pasajeros a bordo del Titanic.', 'Drama', 'https://www.youtube.com/watch?v=2e-eXJ6HgkQ', 16, 200, '4.00', 125, 196, 'https://drive.google.com/file/d/1K1QRP_o_GP6-NTleeYp57owtcxNKhPsE/view?usp=sharing'),
(7, 'La La Land', 'Un pianista de jazz y una aspirante a actriz se enamoran mientras persiguen sus sueños en Los Ángeles', 'Musical', 'https://www.youtube.com/watch?v=0pdqf4P9MB8', 12, 100, '3.80', 120, 128, 'https://drive.google.com/file/d/1FKlBHrhLrLKpVACI_vbpYJkBGP9Fwxtf/view?usp=sharing'),
(8, 'El Padrino', 'La historia de la familia Corleone, una de las más poderosas de la mafia en Nueva York', 'Drama', 'https://www.youtube.com/watch?v=sY1S34973zA', 18, 500, '4.90', 200, 175, 'https://drive.google.com/file/d/1xRMmB0T4J_pHv4eQX2vB3ugt92Hb_KyW/view?usp=sharing'),
(9, 'El Caballero Oscuro', 'Cuando la amenaza conocida como el Joker surge de su misterioso pasado, causa estragos y caos en las personas de Gotham', 'Accion', 'https://www.youtube.com/watch?v=yrJL5JxEYIw', 16, 180, '4.20', 120, 132, 'https://drive.google.com/file/d/1z3ns3I1gD25H7lab-z6_Fp3380tT6rHN/view?usp=sharing'),
(10, 'Forrest Gump', 'Un hombre simple con un corazón puro viaja a través de la historia estadounidense, con encuentros memorables con figuras influyentes y eventos históricos.', 'Comedia', 'https://www.youtube.com/watch?v=8dcYw4OwCA0', 12, 500, '5.00', 200, 142, 'https://drive.google.com/file/d/1SqkX09jpjS3IDaDaIMvdp7xj5suD5kCh/view?usp=sharing'),
(11, 'El silencio de los corderos', 'Un joven agente del FBI busca la ayuda de un asesino en serie encarcelado para capturar a otro asesino en serie que está en libertad.', 'Thriller', 'https://www.youtube.com/watch?v=mDKn4VL8o10', 18, 300, '4.00', 50, 118, 'https://drive.google.com/file/d/1zaGwtznHpLqrk8vPjISb8R5Efsu-eI7K/view?usp=sharing'),
(12, 'Mamma Mia!', ' Una joven que ha crecido en una pequeña isla griega, ha sido educada por una madre rebelde y poco convencional, que siempre se ha negado a revelarle la identidad de su padre. ', 'Musical', 'https://www.youtube.com/watch?v=4LmIS8XFbrM', 0, 600, '5.00', 300, 108, 'https://drive.google.com/file/d/1hY3x6dT_0gtQM21mq7bS3w2RTJSsvaKm/view?usp=sharing');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `idSala` int(3) NOT NULL,
  `idCine` int(4) NOT NULL,
  `idPelicula` int(4) NOT NULL,
  `butacasLibres` int(4) DEFAULT NULL,
  `butacasOcupadas` int(4) DEFAULT NULL,
  `fechaFinal` date DEFAULT NULL,
  `horario` varchar(5) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`idSala`, `idCine`, `idPelicula`, `butacasLibres`, `butacasOcupadas`, `fechaFinal`, `horario`) VALUES
(1, 1, 1, 12, 28, '2023-04-01', '17'),
(2, 2, 10, 0, 40, '2023-03-31', '17'),
(3, 2, 4, 20, 30, '2023-04-09', '17'),
(4, 1, 9, 2, 38, '2023-03-31', '18'),
(5, 3, 2, 10, 40, '2023-04-01', '18'),
(6, 3, 8, 15, 25, '2023-04-11', '17:30'),
(7, 3, 3, 5, 35, '2023-03-29', '18:30'),
(8, 3, 5, 0, 30, '2023-02-15', '18'),
(9, 4, 6, 3, 37, '2023-04-22', '16'),
(10, 4, 7, 2, 38, '2023-04-02', '16'),
(11, 2, 11, 0, 40, '2022-12-20', '17'),
(12, 1, 12, 0, 50, '2023-01-08', '18');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(4) NOT NULL,
  `nombre` varchar(40) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `apellido` varchar(40) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `correo` varchar(40) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `contrasena` varchar(40) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `correo`, `contrasena`) VALUES
(1, 'Juan', 'Perez', 'juan.perez@gmail.com', 'a'),
(2, 'Maria', 'Gonzalez', 'maria.gonzalez@gmail.com', 'a'),
(3, 'Luis', 'Martinez', 'luis.martinez@gmail.com', 'a'),
(4, 'Ana', 'Rodriguez', 'ana.rodriguez@gmail.com', 'a'),
(5, 'Pedro', 'Sanchez', 'pedro.sanchez@gmail.com', 'a');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cine`
--
ALTER TABLE `cine`
  ADD PRIMARY KEY (`idCine`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`idEntrada`),
  ADD KEY `FK_entrada_sala` (`idSala`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`idPelicula`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`idSala`,`idCine`,`idPelicula`),
  ADD KEY `FK_sala_cine` (`idCine`),
  ADD KEY `FK_sala_pelicula` (`idPelicula`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cine`
--
ALTER TABLE `cine`
  MODIFY `idCine` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `idEntrada` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `idPelicula` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `idSala` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `FK_entrada_sala` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`);

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `FK_sala_cine` FOREIGN KEY (`idCine`) REFERENCES `cine` (`idCine`),
  ADD CONSTRAINT `FK_sala_pelicula` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
