-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 21, 2012 at 09:12 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rump0054`
--

-- --------------------------------------------------------

--
-- Table structure for table `c_category`
--

CREATE TABLE IF NOT EXISTS `c_category` (
  `categoryID` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(20) NOT NULL,
  PRIMARY KEY (`categoryID`),
  UNIQUE KEY `category` (`category`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `c_category`
--

INSERT INTO `c_category` (`categoryID`, `category`) VALUES
(5, 'Behaviors'),
(4, 'Distress Tolerance'),
(1, 'Emotion Regulation'),
(7, 'Feelings'),
(2, 'Interpersonal Effect'),
(3, 'Mindfulness Skills'),
(6, 'Thoughts');

-- --------------------------------------------------------

--
-- Table structure for table `c_entries`
--

CREATE TABLE IF NOT EXISTS `c_entries` (
  `entryID` bigint(20) NOT NULL AUTO_INCREMENT,
  `templateID` bigint(20) NOT NULL,
  `categoryID` bigint(20) NOT NULL,
  `targetID` bigint(20) NOT NULL,
  `entryDate` date NOT NULL,
  `value` varchar(3) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`entryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `c_target`
--

CREATE TABLE IF NOT EXISTS `c_target` (
  `targetID` bigint(20) NOT NULL AUTO_INCREMENT,
  `rangeMax` varchar(10) NOT NULL,
  `categoryID` bigint(20) NOT NULL,
  `target` varchar(50) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `username` varchar(15) NOT NULL DEFAULT 'system',
  PRIMARY KEY (`targetID`),
  KEY `category` (`categoryID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `c_target`
--

INSERT INTO `c_target` (`targetID`, `rangeMax`, `categoryID`, `target`, `description`, `username`) VALUES
(1, '0-5', 7, 'Anxiety', 'Feeling Anxiety', 'erumppe'),
(2, '0-5', 7, 'Misery', 'Emotional Misery', 'erumppe'),
(3, '0-5', 7, 'Joy', 'Joy or Happiness', 'erumppe'),
(4, '0-5', 7, 'Stress', 'Feeling Stressed', 'erumppe'),
(5, '0-5', 7, 'Void', 'No Feelings - avoiding feelings.  Anger.', 'erumppe'),
(6, '0-5', 7, 'Bored', 'ADHD Bored Feeling', 'erumppe'),
(7, 'Y/N', 6, 'Self Harm', 'Self Harm or Self Destructive thoughts', 'erumppe'),
(8, 'Y/N', 6, 'Judgements', 'Applying Judgments to myself or others ', 'erumppe'),
(9, '0-5', 5, 'Social', 'Not being at home alone.', 'erumppe'),
(10, 'Y/N', 5, 'Rants', 'Was I ranting', 'erumppe'),
(11, '0-5', 5, 'Mindful', 'How mindful was I during that day', 'erumppe'),
(12, 'Y/N', 5, 'Medication as prescribed', 'Did I take my medications as prescribed', 'erumppe'),
(13, '0-5', 5, 'Increase: Radical Acceptance', 'Raise awareness of situations where radical acceptance can be used and to try and use the skill', 'erumppe'),
(14, 'count', 5, 'Decrease: Judging', 'Raise awareness of judging and try to decrease how often I do it', 'erumppe');

-- --------------------------------------------------------

--
-- Table structure for table `c_target_filled`
--

CREATE TABLE IF NOT EXISTS `c_target_filled` (
  `targetID` bigint(20) NOT NULL AUTO_INCREMENT,
  `rangeMax` varchar(10) NOT NULL,
  `categoryID` bigint(20) NOT NULL,
  `target` varchar(50) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `username` varchar(15) NOT NULL DEFAULT 'system',
  PRIMARY KEY (`targetID`),
  KEY `category` (`categoryID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=74 ;

--
-- Dumping data for table `c_target_filled`
--

INSERT INTO `c_target_filled` (`targetID`, `rangeMax`, `categoryID`, `target`, `description`, `username`) VALUES
(1, '1', 1, 'Opposite Action', 'A lot of our problem behaviors come from trying to avoid emotion, so\r\nopposite action is designed to help us go head first at them, when it’s\r\nappropriate. Opposite action is used when you’re trying to change your\r\nemotion. You determine the emotion that you’re having and figure out the\r\naction urge to it. Once you’ve figured out what the emotion wants you\r\nto do, do the opposite. Remember to do it all the way, so make sure you\r\nare there both physically and mentally. Don’t check out when you get\r\nthere.  \r\n  \r\n This skill may not seem to work immediately, but over time, it will\r\nbegin to work. It’s a lot like building up callouses when playing guitar - it hurts at first but after a while, you don’t even notice.\r\n', 'system'),
(2, '1', 1, 'Accumulate Positives', 'You want to work on gathering some positive experiences, building up a\r\nset of things in your life that you can look to as positive and adding\r\nmeaning to your life. If you don’t have enough going on, do something. A\r\ngood place to look is for a volunteer opportunity. In the US, we have\r\nwww.volunteermatch.org as a good place to start.', 'system'),
(3, '1', 1, 'Build Mastery', 'Do one thing that makes you feel like you’ve accomplished something.\r\nFigure out what you need to do like paying bills, doing the dishes,\r\nreturning phone calls and do them. The size of the activity doesn’t\r\nmatter here, it’s just the fact that you’re doing them at all.\r\n', 'system'),
(4, '1', 1, 'Cope Ahead', 'The skill of coping ahead is a lot like preparing yourself for the worst while hoping for the best. It''s incredibly useful when you know you might be in a triggering situation or around people who are challenging for you to deal with.\r\n\r\nLook at what you’ve got coming up in your day or week and plan ahead for times that you might be challenged emotionally or otherwise. Prepare yourself for those times by rehearsing success, getting your support ready and doing your homework.\r\n', 'system'),
(5, '1', 1, 'Treat Physical Illness', 'Take care of yourself, physically. Go to the doctor, take your medications. If you’re sick, take some time off or reduce your workload.\r\n', 'system'),
(6, '1', 1, 'Balance Eating', ' We tend to ignore things like getting enough to eat when we’re stressed out, but anyone can tell you that not getting enough (or having too much) to eat can be a trigger for heightened emotion. Our goal here is just to get what your body needs - proteins, carbs and fats.\r\n ', 'system'),
(7, '1', 1, 'Avoiding mood altering drugs', ' This app, and DBT as a whole, does not make value judgments on substance use. When we’re talking about times that you’re not already vulnerable to negative emotion, what you do with respect to these substances is up to you. But when you are vulnerable to negative emotion, watch out for them. Things like alcohol, marijuana and other drugs can affect your ability to manage negative emotion and may create situations that generate more emotion than you want to handle. When in doubt, it’s best to abstain if possible. If not, it’s best to minimize harm.\r\n', 'system'),
(8, '1', 1, 'Get Enough Sleep', ' When trying to reduce your vulnerability, it’s important to regulate the amount of sleep you’re getting. Make sure you don’t get too little or too much. Try to get a regular schedule going and establish some routine around it.\r\n ', 'system'),
(9, '1', 1, 'Exercise', ' Exercise has been shown in a variety of studies and through much clinical experience to be an extremely valuable way to reduce negative emotion. Try getting some exercise 3 times per week and remember not to overdo it.\r\n ', 'system'),
(10, '1', 2, 'Prioritize Goals', '  Figure out what you want from a particular interpersonal interaction. You may need to get your goal met, you may want to have a better relationship, you may really want to work on your self-respect. In any of these situations, you need to make sure that you are clear on your own personal priorities.\r\n ', 'system'),
(11, '1', 2, 'Objectives', 'When you want to get your objective met, try to remember to do the following:\r\n\r\n- **Describe** the situation\r\n- **Express** how you feel about it,\r\n- **Ask** for what you want, and\r\n- **Reinforce** the other person.\r\n- being **Mindful**\r\n- **Appearing** confident\r\n- **Negotiating**\r\n \r\n These are not all required, but if you can remember to hit all those high points, you''ll be more likely to succeed. This skill is commonly called "DEAR MAN" in the DBT manual.', 'system'),
(12, '1', 2, 'Relationship Building', 'When you care about how the other person perceives you and feels about\r\nyou after your interaction, make sure that you work on:\r\n\r\n-   Being **Gentle**\r\n-   Acting **Interested**\r\n-   Being **Validating**\r\n-   Having an **Easy manner**\r\n\r\nThis skill is called "GIVE" in the DBT manual.\r\n', 'system'),
(13, '1', 2, 'Self-Respect', 'When dealing with interpersonal situations, it''s sometimes hard to keep (or get some) self-respect. We sometimes sacrifice it to get what we want or we give it up for the sake of the relationship. If you want to keep (or get some) self-respect, make sure you use the following skills:\r\n				\r\n- Being **Fair** to yourself and the other person.\r\n- No **Apologies** unless you’ve violated a wise-mind value.\r\n- **Sticking** to your values.\r\n- Being **Truthful.**\r\n', 'system'),
(14, '1', 2, 'Role-play', 'There''s a saying: practice makes perfect. That''s obviously not always true, but in the case of being interpersonally effective, it certainly doesn''t hurt. Make sure that you role-play any upcoming difficult scenarios.\r\n', 'system'),
(15, '1', 3, 'Observe', '  Using the observe mindfulness skill is about noticing your experience without judgement. You are standing on the bank of a river and watching the water and debris float by without using words.\r\n ', 'system'),
(16, '1', 3, 'Describe', '  Using the *describe mindfulness* skill involves labeling your experience with words, but in a non-judgmental way. *Just the facts*. You are like a play-by-play announcer on the radio broadcast a sporting event.\r\n  ', 'system'),
(17, '1', 3, 'Participate', '  *Participating* is the ultimate goal of Mindfulness skills in DBT. We want you to live your life as it comes. You are fully engaged  in your experience without judging yourself or others.\r\n ', 'system'),
(18, '1', 3, 'Be Non-Judgmental', '  Strive for being as non-judgmental as you can. Being judgmental creates negative emotion and keeps you out of the present moment. Practice being non-judgmental by using your other mindfulness skills.\r\n ', 'system'),
(19, '1', 3, 'Be One Mindful', ' A molecule in chemistry is the smallest unit of a substance that has all the properties of that substance. When practicing mindfulness, try to remember that the goal is for you to do one molecule of behavior at a time. Some activities like breathing feel like a single thing that you&apos;re doing. \r\n				\r\nBut you can also be mindful during more complex activities like driving. There are a lot of smaller tasks that comprise the activity of driving. Pressing the gas, brake, using your turn signals are all part of driving. Talking on the phone or eating are not.\r\n ', 'system'),
(20, '1', 3, 'Be Effective', '  Being mindful is about being as effective as possible. Do what works in your given situation. Let go of the way things "should" be and just do what works for your goal. Play by the rules, even if they are not the "right" rules or ones that you agree with. \r\n ', 'system'),
(21, '1', 4, 'Distraction Skills', 'Distraction skills in intense emotional situations can be very helpful.\r\nTry to do some things to help distract you when you are feeling really\r\nemotional. Remember once you start to feel more in control, practice\r\nanother skill. In the DBT Skills manual, this set of skills is called\r\n*Distract with Wise Mind ACCEPTS*. There are many different types of\r\npractices you can engage in, but here are a few. Make sure to add your\r\nown:\r\n\r\n-   Playing a video game on your device\r\n-   Listening to some music\r\n-   Watching a video\r\n-   Calling a friend or relative\r\n-   Watching a movie that brings up **another emotion**\r\n-   Pushing away the thoughts or "tabling it" for later\r\n-   Using "cognitive load" exercises like word games or mental puzzles\r\n-   Using strong physical sensations to distract you\r\n', 'system'),
(22, '1', 4, 'TIP', 'To go along with times that you need to use sensations, an easy way to remember these skills is to **TIP** your distress:\r\n\r\n- Change your **temperature** by taking a hot or cold shower or using ice.\r\n- Use **intense exercise** to help distract.\r\n- Use **Progressive Relaxation** to help. \r\n', 'system'),
(23, '1', 4, 'Half-Smile', 'Half-smiling involves relaxing all the muscles in your face and neck.\r\nYour mouth is closed but your lips are not pursed. With this relaxed\r\nposture, imagine that you have two strings on the corners of your mouth\r\nslightly pulling up. This is a half-smile. It’s a posture you are\r\ntaking. A way of sitting with your distress - or your distraction. It’s\r\na physiological intervention on your emotional state.', 'system'),
(24, '1', 4, 'Pros and Cons', 'Using pros and cons may be a familiar skill for you, but there’s a\r\nlittle twist to doing it in DBT. Specifically, we work on trying to see\r\nall sides of the issue. If it were an easy, one-sided argument, you\r\nwould not be having a hard time making a decision or struggling with\r\nyour emotion. So, in a DBT pros and cons list, we look at all 4 sides of\r\nthe argument. Pros and cons for being skillful and pros and cons for not\r\nbeing skillful. It’s a refreshing way to look at a problem.', 'system'),
(25, '1', 4, 'Mindful activities', 'When you are extremely distressed, you can start to detach yourself from\r\nyour experience. While it might be hard, try to do some things\r\nmindfully. A few examples:\r\n\r\n-   Watching a television program\r\n-   Eating\r\n-   Walking\r\n-   Listening to music\r\n-   While having a conversation\r\n\r\n', 'system'),
(26, '1', 4, 'Accepting reality', 'We all have a hard time accepting things that we don’t like. We would like to make things different if we had a choice. And if you do have a choice, make it different. But that’s not always possible. When you are struggling with emotion, maybe you are not accepting reality. Work on reducing your suffering by accepting the situation you’re in.', 'system'),
(27, 'Y/N', 5, 'Self-harm behaviors', ' Self-harm behavior is any action that is intended to cause you physical harm. The motivation may be self-punishment or emotion regulation or a combination. These include things like cutting, picking, burning, scratching, headbanging. Anything that can cause bodily harm. As with suicidal ideation, it''s important that you talk with a professional if you are having strong urges to hurt yourself.\r\n ', 'system'),
(28, 'Y/N', 5, 'Drug use behaviors', ' Track actual drug use here. Again, this includes both alcohol and all other non-prescribed, non OTC drug use. \r\n ', 'system'),
(29, 'Y/N', 5, 'Lying', ' Lying can be either by omission or commission. That is, you can either "just leave something out" or intentionally mislead. The more you do it, the more likely you are struggling with emotion or your target behaviors.\r\n ', 'system'),
(30, 'Y/N', 5, 'Impulsive Behaviors', 'Impulsive behaviors include things like:\r\n\r\n-   Speeding\r\n-   Spending money\r\n-   Reckless Driving\r\n-   Things you do without being able to think it through entirely\r\n \r\n				', 'system'),
(31, 'Y/N', 5, 'Stealing', ' Stealing is pretty self-explanatory. It''s taking things that don''t belong to you either out of need or out of want. It can be indicative of emotions lurking and just something to watch out for.\r\n ', 'system'),
(32, '0-5', 6, 'Suicidal Ideation', ' Suicidal ideation consists of thoughts of death, either in an active way or passively. You should be seeing a therapist if you are having these types of thoughts. **Remember that this app is not designed to take the place of your therapist.**\r\n ', 'system'),
(33, '0-5', 6, 'Self-injurious thoughts', ' Track any thoughts you had about engaging in self-injurious behavior. This rating is regardless of whether you used self-harm or not. Engaging in the behavior is a separate question.\r\n ', 'system'),
(34, '0-5', 6, 'Drug use urges', ' Track urges to use drugs here. You should be tracking all types of mood-altering drugs, including alcohol and any non-prescribed, non OTC medications. You will be tracking actual use in the next item.\r\n ', 'system'),
(35, '0-5', 7, 'Joy', '\r\n- Typically felt when you are receiving reinforcement for what you are doing or when you are with people you care about.\r\n- Common similar emotions: happiness, delight\r\n- Ways to foster joy: spend time with people you care about, do things that bring you pleasure and meaning, spend time working on your spirituality\r\n\r\n ', 'system'),
(36, '0-5', 7, 'Pride', '\r\n- Typically felt when you do something that is hard for you, particularly in an interpersonal situation.\r\n- Common similar emotions: satisfaction, self-confidence\r\n- Ways to foster pride: Stand up for yourself, assert your needs, take care of yourself physically\r\n\r\n ', 'system'),
(37, '0-5', 7, 'Anxiety', '\r\n- Typically felt in situations that feel threatening to our life, health or well-being. \r\n- You might feel anxiety when: you’re afraid you might get hurt or you might be judged. You might feel it when you’re worried about something really bad happening to you.\r\n- Common similar emotions: fear, worry, apprehension, nervousness, \r\n- Common urges associated with anxiety: running away, avoiding situations, distracting\r\n- Common opposite actions: approaching, staying in a situation that’s creating the emotion.\r\n\r\n', 'system'),
(38, '0-5', 7, 'Anger', '\r\n- Typically felt when someone does something to block you from achieving an important goal or when you think someone is disrespecting you. \r\n- You might feel anger when: someone cuts you off in traffic, embarrasses you in a public situation, undermines your authority or takes something that is important to you.\r\n- Common similar emotions: rage, frustration, irritation.\r\n- Common urges associated with anger: lashing out, either verbally or physically. Hitting or yelling. \r\n- Common opposite actions: being kind, building empathy, working on acceptance, gently avoiding the situation or person\r\n\r\n ', 'system'),
(39, '0-5', 7, 'Sadness', ' - Typically felt when something important to you is lost or something doesn’t work out the way you had hoped. \r\n- You might feel sadness when: someone close to you dies or leaves your life. When an important goal of yours is no longer possible.\r\n- Common similar emotions: depression, dejection, sorrow, despair\r\n- Common urges associated with sadness: withdrawal, isolation, curling up in bed, crying.\r\n- Common opposite actions: Getting social and active. Working to generate some joy.\r\n ', 'system'),
(40, '0-5', 7, 'Disgust', '- Typically felt when something threatens to make you physically ill or violates a deeply held value of yours.\r\n- You might feel disgust when: you encounter something rotten or otherwise unappetizing. You deal with people who have a moral system that goes against yours.\r\n- Common similar emotions: grossed out, hatred, aversion\r\n- Common urges associated with disgust: cleansing, showering, getting away from, vomiting\r\n- Common opposite actions: Approaching, getting close to or consuming (in the case of a food item)\r\n\r\n ', 'system'),
(41, '0-5', 7, 'Guilt', '- Typically felt when you **engage in a behavior** that violates a\r\n    value.\r\n-   You might feel guilty when: you take something that isn’t yours. Eat\r\n    something you’re "not supposed to". Act in a way that some might\r\n    call selfish.\r\n-   Common similar emotions: regret, remorse\r\n-   Common urges associated with guilt: apologizing, paying penance\r\n-   Common opposite actions: doing the thing that you feel guilty about\r\n    over and over.\r\n', 'system'),
(42, '0-5', 7, 'Shame', '- Typically felt when you think you are a "bad person". When you are living a life that you think others might not approve of.\r\n-   You might feel shame when: you are living a life that you feel you need to keep secret. When you are doing things that you think you need to hide to avoid being humiliated or embarrassed by.\r\n-   Common similar emotions: embarrassment, humiliation\r\n-   Common urges associated with shame: hiding, lying\r\n-   Common opposite actions: exposing your behavior and who you are to those you were hiding from before\r\n\r\n\r\n ', 'system'),
(43, '0-5', 7, 'Pain', ' Physical pain is often a precursor to reacting in unskillful ways and may be an predictor of problems. If your physical pain rating is high, remember to address it before it gets to be problematic.\r\n ', 'system'),
(72, '0-5', 7, 'a', 'a', 'erumppe'),
(73, '0-5', 7, 'b', 'b', 'erumppe');

-- --------------------------------------------------------

--
-- Table structure for table `c_template`
--

CREATE TABLE IF NOT EXISTS `c_template` (
  `templateID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `uid` varchar(15) NOT NULL DEFAULT 'system',
  PRIMARY KEY (`templateID`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `c_template`
--

INSERT INTO `c_template` (`templateID`, `name`, `uid`) VALUES
(1, 'Default', 'system'),
(2, 'Templatesz', 'erumppe'),
(3, 'Descri', 'erumppe'),
(4, 'Card Desc', 'erumppe');

-- --------------------------------------------------------

--
-- Table structure for table `c_template_target`
--

CREATE TABLE IF NOT EXISTS `c_template_target` (
  `templateID` bigint(20) NOT NULL,
  `categoryID` bigint(20) NOT NULL,
  `targetID` bigint(20) NOT NULL,
  `displayOrder` int(11) NOT NULL,
  PRIMARY KEY (`templateID`,`categoryID`,`targetID`),
  KEY `categoryID` (`categoryID`),
  KEY `targetID` (`targetID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `c_template_target`
--

INSERT INTO `c_template_target` (`templateID`, `categoryID`, `targetID`, `displayOrder`) VALUES
(1, 5, 28, 1),
(1, 5, 29, 2),
(1, 5, 30, 3),
(1, 6, 33, 1),
(1, 6, 34, 2),
(1, 7, 35, 1),
(1, 7, 36, 2),
(1, 7, 37, 3),
(1, 7, 38, 4),
(3, 5, 29, 1),
(3, 5, 30, 1),
(3, 6, 34, 1),
(3, 7, 37, 1),
(3, 7, 38, 1),
(3, 7, 39, 1),
(3, 7, 40, 1),
(4, 5, 28, 1),
(4, 5, 29, 1),
(4, 5, 30, 1),
(4, 6, 32, 1),
(4, 6, 33, 1),
(4, 6, 67, 1),
(4, 7, 37, 1),
(4, 7, 65, 1);

-- --------------------------------------------------------

--
-- Table structure for table `emotionlist`
--

CREATE TABLE IF NOT EXISTS `emotionlist` (
  `elid` bigint(20) NOT NULL AUTO_INCREMENT,
  `emotion` varchar(50) NOT NULL,
  PRIMARY KEY (`elid`),
  UNIQUE KEY `emotion` (`emotion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Emotions list for dynamic selects' AUTO_INCREMENT=88 ;

--
-- Dumping data for table `emotionlist`
--

INSERT INTO `emotionlist` (`elid`, `emotion`) VALUES
(1, 'Adored'),
(2, 'Afraid'),
(3, 'Angry'),
(4, 'Annoyed'),
(5, 'Anxious'),
(6, 'Apologetic'),
(7, 'Ashamed'),
(8, 'Blessed'),
(9, 'Blissful'),
(10, 'Bored'),
(11, 'Bothered'),
(12, 'Broken'),
(13, 'Bubbly'),
(14, 'Cautious'),
(15, 'Cheerful'),
(16, 'Confident'),
(17, 'Content'),
(18, 'Curious'),
(19, 'Delighted'),
(20, 'Depressed'),
(21, 'Determined'),
(22, 'Disappointed'),
(23, 'Disgusted'),
(24, 'Disturbed'),
(25, 'Embarrassed'),
(26, 'Empty'),
(27, 'Energetic'),
(28, 'Enlightened'),
(29, 'Enlivened'),
(30, 'Enraged'),
(31, 'Enthusiastic'),
(32, 'Envious'),
(33, 'Excited'),
(34, 'Exhausted'),
(35, 'Flirtatious'),
(36, 'Foolish'),
(37, 'Fragile'),
(38, 'Frightened'),
(39, 'Frustrated'),
(40, 'Glad'),
(41, 'Guilty'),
(42, 'Happy'),
(43, 'Hopeful'),
(44, 'Hopeless'),
(45, 'Horrified'),
(46, 'Hurt'),
(47, 'Hysterical'),
(48, 'Indifferent'),
(49, 'Infatuated'),
(50, 'Interested'),
(51, 'Irritated'),
(52, 'Jealous'),
(53, 'Joyful'),
(54, 'Lively'),
(55, 'Lonely'),
(56, 'Loved'),
(57, 'Loving'),
(58, 'Mad'),
(59, 'Nervous'),
(60, 'Obsessed'),
(61, 'Pleased'),
(62, 'Proud'),
(63, 'Regretful'),
(64, 'Relieved'),
(65, 'Respected'),
(66, 'Restless'),
(67, 'Sad'),
(68, 'Satisfied'),
(69, 'Scared'),
(70, 'Scattered'),
(71, 'Secure'),
(72, 'Shy'),
(73, 'Smart'),
(74, 'Sorry'),
(75, 'Strong'),
(76, 'Surprised'),
(77, 'Suspicious'),
(78, 'Terrified'),
(79, 'Thrilled'),
(80, 'Tired'),
(81, 'Unsure'),
(82, 'Upset'),
(83, 'Vivacious'),
(84, 'Vulnerable'),
(85, 'Worried'),
(86, 'Worthless'),
(87, 'Worthy');

-- --------------------------------------------------------

--
-- Table structure for table `emotionlist_c_target`
--

CREATE TABLE IF NOT EXISTS `emotionlist_c_target` (
  `targetID` bigint(20) NOT NULL AUTO_INCREMENT,
  `rangeMax` varchar(10) NOT NULL,
  `categoryID` bigint(20) NOT NULL,
  `target` varchar(50) NOT NULL,
  `description` varchar(5000) NOT NULL,
  PRIMARY KEY (`targetID`),
  KEY `category` (`categoryID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=88 ;

--
-- Dumping data for table `emotionlist_c_target`
--

INSERT INTO `emotionlist_c_target` (`targetID`, `rangeMax`, `categoryID`, `target`, `description`) VALUES
(1, '0-5', 7, 'Adored', ''),
(2, '0-5', 7, 'Afraid', ''),
(3, '0-5', 7, 'Angry', ''),
(4, '0-5', 7, 'Annoyed', ''),
(5, '0-5', 7, 'Anxious', ''),
(6, '0-5', 7, 'Apologetic', ''),
(7, '0-5', 7, 'Ashamed', ''),
(8, '0-5', 7, 'Blessed', ''),
(9, '0-5', 7, 'Blissful', ''),
(10, '0-5', 7, 'Bored', ''),
(11, '0-5', 7, 'Bothered', ''),
(12, '0-5', 7, 'Broken', ''),
(13, '0-5', 7, 'Bubbly', ''),
(14, '0-5', 7, 'Cautious', ''),
(15, '0-5', 7, 'Cheerful', ''),
(16, '0-5', 7, 'Confident', ''),
(17, '0-5', 7, 'Content', ''),
(18, '0-5', 7, 'Curious', ''),
(19, '0-5', 7, 'Delighted', ''),
(20, '0-5', 7, 'Depressed', ''),
(21, '0-5', 7, 'Determined', ''),
(22, '0-5', 7, 'Disappointed', ''),
(23, '0-5', 7, 'Disgusted', ''),
(24, '0-5', 7, 'Disturbed', ''),
(25, '0-5', 7, 'Embarrassed', ''),
(26, '0-5', 7, 'Empty', ''),
(27, '0-5', 7, 'Energetic', ''),
(28, '0-5', 7, 'Enlightened', ''),
(29, '0-5', 7, 'Enlivened', ''),
(30, '0-5', 7, 'Enraged', ''),
(31, '0-5', 7, 'Enthusiastic', ''),
(32, '0-5', 7, 'Envious', ''),
(33, '0-5', 7, 'Excited', ''),
(34, '0-5', 7, 'Exhausted', ''),
(35, '0-5', 7, 'Flirtatious', ''),
(36, '0-5', 7, 'Foolish', ''),
(37, '0-5', 7, 'Fragile', ''),
(38, '0-5', 7, 'Frightened', ''),
(39, '0-5', 7, 'Frustrated', ''),
(40, '0-5', 7, 'Glad', ''),
(41, '0-5', 7, 'Guilty', ''),
(42, '0-5', 7, 'Happy', ''),
(43, '0-5', 7, 'Hopeful', ''),
(44, '0-5', 7, 'Hopeless', ''),
(45, '0-5', 7, 'Horrified', ''),
(46, '0-5', 7, 'Hurt', ''),
(47, '0-5', 7, 'Hysterical', ''),
(48, '0-5', 7, 'Indifferent', ''),
(49, '0-5', 7, 'Infatuated', ''),
(50, '0-5', 7, 'Interested', ''),
(51, '0-5', 7, 'Irritated', ''),
(52, '0-5', 7, 'Jealous', ''),
(53, '0-5', 7, 'Joyful', ''),
(54, '0-5', 7, 'Lively', ''),
(55, '0-5', 7, 'Lonely', ''),
(56, '0-5', 7, 'Loved', ''),
(57, '0-5', 7, 'Loving', ''),
(58, '0-5', 7, 'Mad', ''),
(59, '0-5', 7, 'Nervous', ''),
(60, '0-5', 7, 'Obsessed', ''),
(61, '0-5', 7, 'Pleased', ''),
(62, '0-5', 7, 'Proud', ''),
(63, '0-5', 7, 'Regretful', ''),
(64, '0-5', 7, 'Relieved', ''),
(65, '0-5', 7, 'Respected', ''),
(66, '0-5', 7, 'Restless', ''),
(67, '0-5', 7, 'Sad', ''),
(68, '0-5', 7, 'Satisfied', ''),
(69, '0-5', 7, 'Scared', ''),
(70, '0-5', 7, 'Scattered', ''),
(71, '0-5', 7, 'Secure', ''),
(72, '0-5', 7, 'Shy', ''),
(73, '0-5', 7, 'Smart', ''),
(74, '0-5', 7, 'Sorry', ''),
(75, '0-5', 7, 'Strong', ''),
(76, '0-5', 7, 'Surprised', ''),
(77, '0-5', 7, 'Suspicious', ''),
(78, '0-5', 7, 'Terrified', ''),
(79, '0-5', 7, 'Thrilled', ''),
(80, '0-5', 7, 'Tired', ''),
(81, '0-5', 7, 'Unsure', ''),
(82, '0-5', 7, 'Upset', ''),
(83, '0-5', 7, 'Vivacious', ''),
(84, '0-5', 7, 'Vulnerable', ''),
(85, '0-5', 7, 'Worried', ''),
(86, '0-5', 7, 'Worthless', ''),
(87, '0-5', 7, 'Worthy', '');

-- --------------------------------------------------------

--
-- Table structure for table `userpass`
--

CREATE TABLE IF NOT EXISTS `userpass` (
  `username` varchar(15) NOT NULL COMMENT 'User login name',
  `password` varchar(15) NOT NULL COMMENT 'User login password',
  `firstName` varchar(255) DEFAULT NULL COMMENT 'First Name',
  `lastName` varchar(255) DEFAULT NULL COMMENT 'Last Name',
  `email` varchar(255) DEFAULT NULL COMMENT 'Email address for noticifications',
  `type` enum('patient','provider','other') NOT NULL DEFAULT 'patient',
  `provider` varchar(15) DEFAULT NULL,
  `templateID` bigint(20) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Stores user login credentials';

--
-- Dumping data for table `userpass`
--

INSERT INTO `userpass` (`username`, `password`, `firstName`, `lastName`, `email`, `type`, `provider`, `templateID`) VALUES
('erumppe', 'ganewa4', 'Erik', 'Rumppe', 'erumppe@gmail.com', 'patient', 'gshaller', 3),
('gshaller', 'gshaller', 'Gary', 'Shaller', 'gshaller@kaiser.org', 'provider', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `userrole`
--

CREATE TABLE IF NOT EXISTS `userrole` (
  `username` varchar(15) NOT NULL COMMENT 'User login name links to userpass',
  `rolename` varchar(15) NOT NULL COMMENT 'Roles associated with the users login',
  PRIMARY KEY (`username`,`rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Store user roles/permissions';

--
-- Dumping data for table `userrole`
--

INSERT INTO `userrole` (`username`, `rolename`) VALUES
('erumppe', 'admin'),
('erumppe', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `u_card`
--

CREATE TABLE IF NOT EXISTS `u_card` (
  `cardID` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL,
  `weekStart` date NOT NULL,
  PRIMARY KEY (`cardID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `u_card`
--

INSERT INTO `u_card` (`cardID`, `username`, `weekStart`) VALUES
(3, 'erumppe', '2012-02-19');

-- --------------------------------------------------------

--
-- Table structure for table `u_card_template`
--

CREATE TABLE IF NOT EXISTS `u_card_template` (
  `cardID` bigint(20) NOT NULL,
  `targetID` bigint(20) NOT NULL,
  PRIMARY KEY (`cardID`,`targetID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Card Targets per Template';

--
-- Dumping data for table `u_card_template`
--

INSERT INTO `u_card_template` (`cardID`, `targetID`) VALUES
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 6),
(3, 7),
(3, 8),
(3, 9),
(3, 10),
(3, 11),
(3, 12),
(3, 13),
(3, 14);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
