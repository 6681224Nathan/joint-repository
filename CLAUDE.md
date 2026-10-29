# CLAUDE.md

Pin's study repo (2nd-year CS student). Each task is usually separate, so check files before assuming.

## About Pin
- Weak in web dev, often rushing. Wants plain-language, step-by-step explanations, not deep jargon.
- Assignments follow a "50/50 AI" rule: Pin must be able to explain every error and fix. Work is shown in class, not submitted in Teams. Teach, don't just dump code.
- Wants real tested results. Be token-efficient: short answers, no long recaps.
- Use diagrams only when they genuinely help.

## Courses
- **EGCI427 Web Programming** (JS/ES6, Node, Express, MongoDB/Mongoose, JWT, bcrypt, Postman/Newman)
- **EGCI232** (electronics): see `EE/`
- Microprocessor and interfacing: see `microprocessor and interfacing/`
- Softeng diagrams, other coursework live in their own folders.

## Web programming layout
- Lessons: `web_programming/js-course/00–10*.md` (JS, async, Node tools, server by hand, Express)
- Practices and labs: `~/Desktop/web_programming_workspace/practice_XX/` (shared `node_modules` at workspace root) and `nodeMongoose/practice_17`, `practice_18`
- Latest lab: `practice_20` (Week 5: auth with JWT + bcrypt, User model, `routes/auth.js`)
- Assignments (one folder each: `instruction.md` + answer code): `web_programming_workspace/assignments/`. Still missing: in-class02-03 and In-class04, which need Pin to paste the instruction text.
- MongoDB launcher: `web_programming_workspace/mongodb/start-mongodb.command` (Studio 3T used in class)

## Conventions
- Practices usually get `app.js` (clean, no comments) plus `app_claude.js` (heavily commented, beginner-friendly).
- Don't edit code Pin is writing themselves unless asked. Point out the bug and hint first.
- Test against a throwaway MongoDB (separate port and env overrides). Never touch Pin's real DB.
- Newman resets collection variables each run, so reseed before runs. Postman keeps them.

## Known loose ends
- practice_13 (products CRUD) unfinished; practice_14 has 2 bugs (`req.body` on GET, form `method` mismatch).
- Check professor's Postman collections for exact status codes (POST 201/200, login failure code).
