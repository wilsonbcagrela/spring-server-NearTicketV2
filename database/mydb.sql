-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21-Jul-2021 às 19:24
-- Versão do servidor: 10.4.6-MariaDB
-- versão do PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `mydb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `user_Name` varchar(45) DEFAULT NULL,
  `first_Name` varchar(45) DEFAULT NULL,
  `last_Name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `is_Admin` tinyint(4) DEFAULT NULL,
  `is_email_confirmed` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`id`, `user_Name`, `first_Name`, `last_Name`, `email`, `password`, `phone`, `role`, `is_Admin`, `is_email_confirmed`) VALUES
(1, 'HelpDesk', 'help', 'desk', 'helpdesk@hotmail.com', 'qwerty', 12345, 2, 1, b'0'),
(2, 'tecnico', 'tec', 'nico', 'tecnico@hotmail.com', 'qwerty', 12345, 0, 1, b'0'),
(3, 'consultant', 'cons', 'ultant', 'consultor@hotmail.com', 'qwerty', 91919191, 1, 1, b'0'),
(7, 'tecnicoNovo', 'tecnico', 'novo', 'tecnicoNovo@hotmail.com', 'qwerty', 192836, 0, 1, b'0'),
(8, 'conSultor', 'con', 'ultor', 'consultor2@hotmail.com', 'qwerty', 123456789, 1, 1, b'0');

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin_has_project`
--

CREATE TABLE `admin_has_project` (
  `Admin_id` int(11) NOT NULL,
  `Project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `admin_has_project`
--

INSERT INTO `admin_has_project` (`Admin_id`, `Project_id`) VALUES
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 14),
(1, 15),
(1, 16),
(2, 9),
(2, 10),
(2, 11),
(2, 12),
(2, 14),
(2, 15),
(2, 16),
(3, 9),
(3, 10),
(3, 11),
(3, 12),
(3, 14),
(3, 15),
(3, 16),
(7, 10),
(7, 11),
(7, 12),
(7, 14),
(7, 15),
(7, 16),
(8, 15),
(8, 16);

-- --------------------------------------------------------

--
-- Estrutura da tabela `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `is_Email_Confirmed` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `client`
--

INSERT INTO `client` (`id`, `name`, `password`, `email`, `phone`, `is_Email_Confirmed`) VALUES
(2, 'nearsoft', 'qwerty', 'nearsoft@hotmail.com', 123456, 0),
(3, 'new Client', 'qwerty', 'newClientTest@hotmail.com', 91283746, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `creation_date` date DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `ticket_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `comment`
--

INSERT INTO `comment` (`id`, `creation_date`, `owner`, `text`, `ticket_id`) VALUES
(1, '2021-07-12', 'user1', 'this is a comment', 32),
(11, '2021-07-18', 'tecnico', 'hello can you give more detail about this ticket please?', 34),
(12, '2021-07-18', 'userOne', 'yes i can', 34);

-- --------------------------------------------------------

--
-- Estrutura da tabela `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `project`
--

INSERT INTO `project` (`id`, `name`, `description`) VALUES
(9, 'NewProject', 'Project of the new client'),
(10, 'Project 2', 'this is the project 2'),
(11, 'Project test', 'This is a teste project'),
(12, 'Project test 2', 'This is another test project'),
(14, 'Laravel project', 'This project was done on laravel'),
(15, 'Projects4', 'This is the project of user4'),
(16, 'Project test', 'This is a project test');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ticket`
--

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `urgency` tinyint(4) DEFAULT NULL,
  `supervisor` varchar(45) DEFAULT NULL,
  `Project_id` int(11) NOT NULL,
  `is_issue` bit(1) DEFAULT NULL,
  `is_request` bit(1) DEFAULT NULL,
  `gravity` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT 0,
  `owner` varchar(255) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `dead_line` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `ticket`
--

INSERT INTO `ticket` (`id`, `name`, `description`, `urgency`, `supervisor`, `Project_id`, `is_issue`, `is_request`, `gravity`, `status`, `owner`, `creation_date`, `dead_line`) VALUES
(24, 'Fix this please', 'fix view home has some bugs', 0, 'tecnico', 10, b'1', b'0', 0, 2, 'userOne', '2021-07-12', '2021-07-15'),
(25, 'request to make new feature', 'would like to remove users from a project', 1, 'consultant', 10, b'0', b'1', 2, 1, 'userOne', '2021-07-12', '2021-07-13'),
(26, 'error trying to make a new account', 'You can create a user with the same email and username please fix', 1, 'tecnico', 10, b'1', b'0', 2, 2, 'userOne', '2021-07-12', '2021-07-13'),
(27, 'lorem ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 0, NULL, 14, b'0', b'0', 1, 0, 'userOne', '2021-07-12', '2021-07-15'),
(28, 'Why do we use it?', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 1, NULL, 14, b'0', b'0', 2, 0, 'userOne', '2021-07-12', '2021-07-27'),
(29, 'Where does it come from?', 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.', 0, NULL, 14, b'0', b'0', 0, 0, 'userOne', '2021-07-12', '2021-09-30'),
(30, 'Where can I get this?', 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don\'t look even slightly believable. If you are going to use a passage of Lorem Ipsum', 0, NULL, 9, b'0', b'1', 1, 0, 'userOne', '2021-07-12', '2021-07-15'),
(31, 'Lorem Ipsum', 'Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy.', 0, NULL, 9, b'1', b'0', 1, 0, 'userOne', '2021-07-12', '2021-07-22'),
(32, 'correction', 'this is a correction', 0, 'consultant', 10, b'0', b'1', 0, 1, 'userOne', '2021-07-12', '2021-07-22'),
(34, 'Ticket test', 'This is a ticket to test the ability of this system to create tickets', 0, 'tecnico', 16, b'1', b'0', 0, 1, 'userOne', '2021-07-17', '2021-07-20'),
(35, 'Another test ticket', 'this is another test ticket', 1, NULL, 16, b'0', b'1', 2, 0, 'userOne', '2021-07-17', '2021-07-23');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `user_Name` varchar(45) DEFAULT NULL,
  `first_Name` varchar(45) DEFAULT NULL,
  `last_Name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `Client_id` int(11) NOT NULL,
  `is_email_confirmed` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`id`, `user_Name`, `first_Name`, `last_Name`, `email`, `password`, `phone`, `Client_id`, `is_email_confirmed`) VALUES
(1, 'joseMendes', 'jose', 'mendes', 'jose@hotmail.com', 'qwerty', 96505186, 2, b'0'),
(3, 'userOne', 'user', 'one', 'user1@hotmail.com', 'qwerty', 12213443, 3, b'0'),
(4, 'userTwo', 'user', 'two', 'user2@hotmail.com', 'qwerty', 12213123, 3, b'0'),
(5, 'userThree', 'user', 'Three', 'user3@hotmail.com', 'qwerty', 12312321, 3, b'0'),
(7, 'userFour', 'user', 'four', 'user4@hotmail.com', 'qwerty', 965051213, 3, b'0');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_has_project`
--

CREATE TABLE `user_has_project` (
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user_has_project`
--

INSERT INTO `user_has_project` (`user_id`, `project_id`) VALUES
(3, 9),
(3, 10),
(3, 14),
(3, 15),
(3, 16),
(4, 9),
(4, 10),
(4, 14),
(4, 15),
(5, 9),
(5, 10),
(5, 14),
(5, 15),
(7, 9),
(7, 14),
(7, 15);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Índices para tabela `admin_has_project`
--
ALTER TABLE `admin_has_project`
  ADD PRIMARY KEY (`Admin_id`,`Project_id`),
  ADD KEY `fk_Admin_has_Project_Project1_idx` (`Project_id`),
  ADD KEY `fk_Admin_has_Project_Admin1_idx` (`Admin_id`);

--
-- Índices para tabela `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idCliente_UNIQUE` (`id`);

--
-- Índices para tabela `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsyf8wt2qb7rhcau6v3p4axrba` (`ticket_id`);

--
-- Índices para tabela `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Índices para tabela `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`,`Project_id`),
  ADD UNIQUE KEY `idTicket_UNIQUE` (`id`),
  ADD KEY `fk_Ticket_Project1_idx` (`Project_id`);

--
-- Índices para tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`,`Client_id`),
  ADD UNIQUE KEY `idUtilizador_UNIQUE` (`id`),
  ADD KEY `fk_User_Client1_idx` (`Client_id`);

--
-- Índices para tabela `user_has_project`
--
ALTER TABLE `user_has_project`
  ADD PRIMARY KEY (`user_id`,`project_id`),
  ADD KEY `FKnvhpj5hulo2072374a0tfnn7s` (`project_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `admin_has_project`
--
ALTER TABLE `admin_has_project`
  ADD CONSTRAINT `FK31vgsciprmg60h1882dpvnevt` FOREIGN KEY (`Admin_id`) REFERENCES `admin` (`id`),
  ADD CONSTRAINT `FK579tfl7v48xh86tpwq77244cx` FOREIGN KEY (`Project_id`) REFERENCES `project` (`id`),
  ADD CONSTRAINT `fk_Admin_has_Project_Admin1` FOREIGN KEY (`Admin_id`) REFERENCES `admin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Admin_has_Project_Project1` FOREIGN KEY (`Project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FKsyf8wt2qb7rhcau6v3p4axrba` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`);

--
-- Limitadores para a tabela `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_Ticket_Project1` FOREIGN KEY (`Project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_User_Client1` FOREIGN KEY (`Client_id`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `user_has_project`
--
ALTER TABLE `user_has_project`
  ADD CONSTRAINT `FK3vfdbf97lt1y2yvr6ad9nwpho` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKnvhpj5hulo2072374a0tfnn7s` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
