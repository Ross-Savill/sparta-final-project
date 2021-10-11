##Fixes

Below are a list of compiled problems with the website which need to be fixed:


###All Pages:

1. All buttons besides the Submit buttons require the text to be clicked, the buttons themselves do not link to other pages.



2. No dialogue box is raised following the clicking of a Delete button at any point on the website despite featuring in the User Stories. Dialogue boxes inviting the user to confirm or cancel the delete process need to be implemented on the Trainee, Trainer, Course, Course Type, Centre and Discipline sections of the website.



3. All Edit Pages (not Add Pages) allow for the submission of blank fields and all pages with inputs allow for the submission of special characters which don’t feature in names etc.



###Scheduler Page:

1. The second part of the holiday shaded area moves to the end of the dates area once a trainee is deleted.



###Trainees Page:

1. It is possible to add a quality gate with a date set in the future

2. It is possible to add the same trainer as both trainer one and two.

3. “Trainee ID” comes through as the trainee ID number while “Trainer ID” comes through as the trainers names.

4. “Trainee ID” is editable when it should be fixed.

###Trainers Page:

1. The addition of trainers with the same colour is permitted but should be stopped according to the User Stories.

###Courses Page:

1. It’s possible to add the same trainer multiple times in the slots for adding trainers.

2. It is possible to set the end week to come before the start week.

###Course Info Page:

1. The “Remove” button under the “Edit Discipline” section causes an error page to appear.

2. It is possible to add/edit a discipline with 0 weeks.

###Centres Page:

1. On the Edit Location page there exists a delete button. This button leads to a white error screen as no Spring controllers exist to handle the request.

2. It is possible to create a centre with 0 rooms.

##Recommendations

###Scheduler Page:

1. There is no indication that the schedule is clickable and yields more information. Text and a cursor change would help make this clearer.

###Trainees Page:

1. The Add Quality Gate page displays an editable ID field which yields no extra information to the user and causes errors if changed. This should be removed.

2. Adding a new trainee causes the page to refresh but doesn’t return the user to the trainees page which differs from other “add” sections of the website.

###Course Page:

1. New courses (that have been added) aren’t always put at the top, which may lead to confusion about whether they’ve been added. Make all newly added courses appear at the top (ordered list - newest to latest).

2. Introduce a ‘Remove all’ button (along with a confirmation box), for quality-of-life if the user decides they no longer need any of the current courses.

###Course Info Page:

1. As Disciplines call already be removed through the centres page, the Delete button on the Edit page could be removed. It currently just causes an error screen.


###Centres Page:

1. While the main page is called “Centres”, the subsequent add/edit fields refer to “Locations” which is confusing.

2. The “Delete” button should be removed from the “Edit” section as you can already delete a location from outside on the Centres page. 