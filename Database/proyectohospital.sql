-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-12-2021 a las 06:09:56
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectohospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `id_cita` int(10) NOT NULL,
  `doctor` varchar(255) NOT NULL,
  `paciente` varchar(255) NOT NULL,
  `hospital` varchar(100) NOT NULL,
  `tipo_operacion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`id_cita`, `doctor`, `paciente`, `hospital`, `tipo_operacion`) VALUES
(1, 'Luis', 'Ricardo', '', ''),
(2, 'Allan', 'Maria', 'Hospital Central', 'Ambulatoria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_postoperatoria`
--

CREATE TABLE `cita_postoperatoria` (
  `id_postoperatoria` int(11) NOT NULL,
  `hospital` varchar(100) NOT NULL,
  `paciente` varchar(100) NOT NULL,
  `fecha` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_postoperatoria`
--

INSERT INTO `cita_postoperatoria` (`id_postoperatoria`, `hospital`, `paciente`, `fecha`) VALUES
(1, 'Hospital Central', 'Maria', '13/12/2021');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleados` int(10) NOT NULL,
  `identificacion` varchar(20) NOT NULL,
  `nombre` text NOT NULL,
  `primer_apellido` text NOT NULL,
  `segundo_apellido` text NOT NULL,
  `grado_academico` varchar(100) NOT NULL,
  `profesion` varchar(100) NOT NULL,
  `especialidad` varchar(100) NOT NULL,
  `telefono` int(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `estado_civil` varchar(30) NOT NULL,
  `id_profesion` int(10) DEFAULT NULL,
  `id_especialidad` int(10) DEFAULT NULL,
  `id_cirugias` int(10) DEFAULT NULL,
  `id_usuario` int(10) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleados`, `identificacion`, `nombre`, `primer_apellido`, `segundo_apellido`, `grado_academico`, `profesion`, `especialidad`, `telefono`, `correo`, `estado_civil`, `id_profesion`, `id_especialidad`, `id_cirugias`, `id_usuario`, `usuario`) VALUES
(1, '22222222', 'Luis', 'Solis', 'Perez', 'Licenciatura', '', '', 88888884, 'luis@gmail.com', 'Soltero(a)', NULL, NULL, NULL, NULL, NULL),
(2, '33333333', 'Allan', 'Albiol', 'Sequeira', 'MBA', '', '', 8888888, 'allan@gmail.com', 'Soltero(a)', NULL, NULL, NULL, NULL, NULL),
(3, '333', 'Isabel', 'Rojas', 'Salas', 'Secundaria', 'secretaria', 'Secretaria', 8888883, 'isabel@gmail.com', 'Soltero(a)', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id_especialidad` int(10) NOT NULL,
  `especialidad` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id_especialidad`, `especialidad`) VALUES
(1, 'dermatologia'),
(2, 'Anestesia'),
(4, 'Medicina General'),
(5, 'Neurologia'),
(6, 'Pediatria'),
(7, 'Cardiologia'),
(8, 'Secretaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hospitales`
--

CREATE TABLE `hospitales` (
  `id_hospital` int(10) NOT NULL,
  `nombre_hospital` varchar(255) NOT NULL,
  `provincia` text NOT NULL,
  `canton` text NOT NULL,
  `distrito` text NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `pisos` int(10) NOT NULL,
  `consultorios` text NOT NULL,
  `año_construccion` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hospitales`
--

INSERT INTO `hospitales` (`id_hospital`, `nombre_hospital`, `provincia`, `canton`, `distrito`, `direccion`, `pisos`, `consultorios`, `año_construccion`) VALUES
(1, 'Hospital Central', 'San Jose', 'Central', 'La merced', 'Av 2', 5, '30', 1960);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `internamiento`
--

CREATE TABLE `internamiento` (
  `id_internamientos` int(10) NOT NULL,
  `fecha_inicio_internamiento` varchar(30) NOT NULL,
  `motivo_internamiento` varchar(100) NOT NULL,
  `paciente` varchar(100) NOT NULL,
  `hospital` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `internamiento`
--

INSERT INTO `internamiento` (`id_internamientos`, `fecha_inicio_internamiento`, `motivo_internamiento`, `paciente`, `hospital`) VALUES
(1, '12/12/2021', 'Coma', 'Jose', 'Hospital Central');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `id_paciente` int(10) NOT NULL,
  `cedula` int(30) NOT NULL,
  `primer_apellido` varchar(50) NOT NULL,
  `segundo_apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` int(20) NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `estado_paciente` varchar(10) NOT NULL,
  `id_pagos` int(10) DEFAULT NULL,
  `id_citas` int(10) DEFAULT NULL,
  `id_internamientos` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`id_paciente`, `cedula`, `primer_apellido`, `segundo_apellido`, `nombre`, `telefono`, `estado_civil`, `correo`, `estado_paciente`, `id_pagos`, `id_citas`, `id_internamientos`) VALUES
(1, 123123123, 'Monge', 'Zuñiga', 'Ricardo', 88888888, 'Soltero(a)', 'ricardo@gmail.com', 'Activo', 0, 0, 0),
(2, 123123124, 'Perez', 'Rojas', 'Maria', 88888889, 'Casado(a)', 'maria@gmail.com', 'Inactivo', 0, 0, 0),
(3, 123123456, 'Solis', 'Pacheco', 'Jose', 888887, 'Soltero(a)', 'jose@gmail.com', 'Activo', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `id_pagos` int(20) NOT NULL,
  `id_paciente` int(20) NOT NULL,
  `primer_apellido` varchar(50) NOT NULL,
  `segundo_apellido` varchar(50) NOT NULL,
  `nombre_paciente` varchar(50) NOT NULL,
  `monto_cirugia` int(50) NOT NULL,
  `monto_internamiento` int(50) NOT NULL,
  `metodo_cancelacion` varchar(20) NOT NULL,
  `id_cirugia` int(10) NOT NULL,
  `tipo_operacion` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesion`
--

CREATE TABLE `profesion` (
  `id_profesion` int(10) NOT NULL,
  `profesion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `profesion`
--

INSERT INTO `profesion` (`id_profesion`, `profesion`) VALUES
(1, 'doctor'),
(2, 'secretaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(10) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `usuario`, `password`, `rol`) VALUES
(1, 'wer', 'wer', '123', 'Doctor'),
(2, 'Ricardo Monge', 'rmonge', '123', 'Doctor');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`id_cita`);

--
-- Indices de la tabla `cita_postoperatoria`
--
ALTER TABLE `cita_postoperatoria`
  ADD PRIMARY KEY (`id_postoperatoria`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleados`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indices de la tabla `hospitales`
--
ALTER TABLE `hospitales`
  ADD PRIMARY KEY (`id_hospital`);

--
-- Indices de la tabla `internamiento`
--
ALTER TABLE `internamiento`
  ADD PRIMARY KEY (`id_internamientos`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id_paciente`);

--
-- Indices de la tabla `profesion`
--
ALTER TABLE `profesion`
  ADD PRIMARY KEY (`id_profesion`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `id_cita` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cita_postoperatoria`
--
ALTER TABLE `cita_postoperatoria`
  MODIFY `id_postoperatoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleados` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id_especialidad` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `hospitales`
--
ALTER TABLE `hospitales`
  MODIFY `id_hospital` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `internamiento`
--
ALTER TABLE `internamiento`
  MODIFY `id_internamientos` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id_paciente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `profesion`
--
ALTER TABLE `profesion`
  MODIFY `id_profesion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
