-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 06-Abr-2018 às 02:26
-- Versão do servidor: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cesjf`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `dataMatricula` date NOT NULL,
  `endereco` text NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `altura` float(15,2) NOT NULL,
  `peso` float(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`id`, `nome`, `dataMatricula`, `endereco`, `telefone`, `dataNascimento`, `altura`, `peso`) VALUES
(1, 'jaum', '2018-02-22', 'endereco1', '00000000', '2018-02-22', 1.72, 80.00),
(2, 'Maria', '2018-02-22', 'endereco2', '00000000', '2018-02-22', 1.58, 50.00),
(3, 'ze', '2018-02-22', 'endereco3', '00000000', '2018-02-22', 1.72, 80.00),
(4, 'zezinho', '2018-02-22', 'endereco4', '00000000', '2018-02-22', 1.72, 80.00),
(5, 'jaumzinho', '2018-02-22', 'endereco5', '00000000', '2018-02-22', 1.72, 80.00),
(6, 'John', '2018-02-28', 'Rua', '00000000', '2018-02-28', 1.90, 82.50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `ID_CID` int(11) NOT NULL,
  `NOME_CID` varchar(60) NOT NULL,
  `UF_CID` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`ID_CID`, `NOME_CID`, `UF_CID`) VALUES
(1, 'JUIZ DE FORA', 'MG'),
(2, 'RIO DE JANEIRO', 'RJ'),
(3, 'São Paulo', 'Sp'),
(4, 'Curitiba', 'PR');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `for_id` int(11) NOT NULL,
  `for_nome` varchar(50) NOT NULL,
  `for_rua` varchar(100) NOT NULL,
  `for_numero` int(11) NOT NULL,
  `for_bairro` varchar(50) NOT NULL,
  `for_cidade` varchar(100) NOT NULL,
  `for_uf` char(2) NOT NULL,
  `for_telefone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`for_id`, `for_nome`, `for_rua`, `for_numero`, `for_bairro`, `for_cidade`, `for_uf`, `for_telefone`) VALUES
(1, 'Microsoft', 'Teste', 123, 'Teste', 'Juiz de Fora', 'MG', '3232323232');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `pro_codigo` int(11) NOT NULL,
  `pro_nome` varchar(50) NOT NULL,
  `pro_descricao` varchar(100) NOT NULL,
  `pro_preco` float NOT NULL,
  `pro_for_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`pro_codigo`, `pro_nome`, `pro_descricao`, `pro_preco`, `pro_for_codigo`) VALUES
(1, 'Windows 10', 'Windows 10', 350, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `uf`
--

CREATE TABLE `uf` (
  `ID_UF` int(11) NOT NULL,
  `SIGLA_UF` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `uf`
--

INSERT INTO `uf` (`ID_UF`, `SIGLA_UF`) VALUES
(1, 'MG'),
(2, 'RJ'),
(3, 'SP'),
(4, 'PR');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`ID_CID`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`for_id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`pro_codigo`),
  ADD KEY `pro_for_codigo_fk` (`pro_for_codigo`);

--
-- Indexes for table `uf`
--
ALTER TABLE `uf`
  ADD PRIMARY KEY (`ID_UF`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `ID_CID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `for_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `pro_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `uf`
--
ALTER TABLE `uf`
  MODIFY `ID_UF` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `pro_for_codigo_fk` FOREIGN KEY (`pro_for_codigo`) REFERENCES `fornecedor` (`for_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
