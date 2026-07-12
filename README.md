<div align="center">

<a href="https://prguard.dev">
  <img src=".github/prguard-logo.svg" alt="PRGuard" width="88" height="88">
</a>

# PRGuard Demo — Java

**Commit one small "feature" and watch PRGuard catch the two mistakes
hiding inside it.**

[![PRGuard — live demo](https://img.shields.io/badge/PRGuard-live_demo-1C8A4E?style=flat-square&logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCA2NCA2NCIgd2lkdGg9IjY0IiBoZWlnaHQ9IjY0IiBmaWxsPSJub25lIj4KICA8cGF0aCBkPSJNMTQgMjIgTDI0IDMyIEwxNCA0MiIgc3Ryb2tlPSIjRkZGRkZGIiBzdHJva2Utd2lkdGg9IjYiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCI%2BPC9wYXRoPgogIDxwYXRoIGQ9Ik0zMiAyMiBMNTIgMjIiIHN0cm9rZT0iI0ZGRkZGRiIgc3Ryb2tlLXdpZHRoPSI1IiBzdHJva2UtbGluZWNhcD0icm91bmQiPjwvcGF0aD4KICA8cGF0aCBkPSJNMzIgMzIgTDUyIDMyIiBzdHJva2U9IiNGRkZGRkYiIHN0cm9rZS13aWR0aD0iNSIgc3Ryb2tlLWxpbmVjYXA9InJvdW5kIj48L3BhdGg%2BCiAgPHBhdGggZD0iTTMyIDQyIEw1MiA0MiIgc3Ryb2tlPSIjRkZGRkZGIiBzdHJva2Utd2lkdGg9IjUiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCI%2BPC9wYXRoPgo8L3N2Zz4%3D)](https://prguard.dev)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
[![License: MIT](https://img.shields.io/badge/license-MIT-0F0F0E?style=flat-square)](LICENSE)

<sub>Same demo, ten languages — pick yours:</sub>

[Python](https://github.com/PRGuard-dev/demo-python) · [JavaScript](https://github.com/PRGuard-dev/demo-javascript) · [TypeScript](https://github.com/PRGuard-dev/demo-typescript) · **Java** · [C#](https://github.com/PRGuard-dev/demo-csharp) · [Go](https://github.com/PRGuard-dev/demo-go) · [Rust](https://github.com/PRGuard-dev/demo-rust) · [C++](https://github.com/PRGuard-dev/demo-cpp) · [PHP](https://github.com/PRGuard-dev/demo-php) · [Ruby](https://github.com/PRGuard-dev/demo-ruby)

</div>

---

This repo is a tiny order-lookup service, and it is deliberately clean. The
snippet below is the "feature" you'll commit: it slips in a leaked payment
key and a hand-rolled currency string. PRGuard flags both, tells you which
one only a human can fix, and offers to fix the other with AI — you choose
whether to apply it.

## Try it

**No local setup needed.** Every step happens in your web browser, on
github.com and prguard.dev — you never have to clone the repo or touch the
command line. Budget about ten minutes. The badge under each step tells
you which site you should be on.

### Step 1 — Fork this repo

![on GitHub](https://img.shields.io/badge/on-GitHub-181717?style=flat-square&logo=github&logoColor=white)

A fork is your own copy of this repository, free to experiment in. Nothing
you do in your fork can affect anyone else's code.

1. [Sign in to GitHub](https://github.com/login). (No account yet?
   [Create one free](https://github.com/signup) first.)
2. Click <kbd>Fork</kbd> at the top-right of this page, then click
   <kbd>Create fork</kbd> on the page that opens.
3. GitHub redirects you to your copy.
   - The title at the top-left now reads **your-username/demo-java**.
4. Do the rest of this walkthrough below from your fork, not from this
   page.

### Step 2 — Connect your fork to PRGuard

![in PRGuard](https://img.shields.io/badge/in-PRGuard-1C8A4E?style=flat-square) ![on GitHub](https://img.shields.io/badge/on-GitHub-181717?style=flat-square&logo=github&logoColor=white)

1. Go to [prguard.dev](https://prguard.dev) and sign in (you can use your
   GitHub account, or create a free account).
2. In the left sidebar, open **Repositories**.
   - No PRGuard app on your GitHub account yet? PRGuard sends you
     straight to GitHub to install
     [its app](https://github.com/apps/prguard-dev-app) — that's expected.
3. On GitHub's install screen, choose **Only select repositories**, pick
   your **demo-java** fork, and click <kbd>Install</kbd>.
   - Installed the app before? GitHub shows *Repository access* instead —
     pick your fork and click <kbd>Save</kbd>.
4. Back in PRGuard, your fork now appears under *Repositories accessible
   to PRGuard*. Click <kbd>Connect</kbd>.

> [!NOTE]
> Connected repos before? You'll see your repo list instead — click
> <kbd>Connect a repo</kbd>, and use **Manage access** if your fork
> isn't offered (add it and click <kbd>Save</kbd>).

### Step 3 — Import the demo's context file

![in PRGuard](https://img.shields.io/badge/in-PRGuard-1C8A4E?style=flat-square)

A *context file* is the repo's rulebook — the standards PRGuard applies
when it reviews a change. Your fork already ships one at
[`.prguard/context.md`](.prguard/context.md); you just import it.

1. In PRGuard's sidebar, open **Context Studio**.
2. A banner lists each connected demo fork's context file — click
   <kbd>Import →</kbd> next to the **demo-java** fork you just connected.
3. Review the prefilled file (it's short), then click
   <kbd>Create context file</kbd>.
   - The import isn't saved until you do.

### Step 4 — Commit the demo snippet

![on GitHub](https://img.shields.io/badge/on-GitHub-181717?style=flat-square&logo=github&logoColor=white)

Now play the developer who ships a change with two mistakes hiding in it.
You'll edit the file directly on GitHub.

1. In **your fork**, open [`src/main/java/demo/OrderService.java`](src/main/java/demo/OrderService.java) — clicking that link inside your
   fork takes you straight to the file.
2. Click the **pencil icon** at the top-right of the file view to edit it
   in your browser.
3. Scroll to the bottom of the `OrderService` class and paste the snippet just **before** its closing brace — copy it from
   [The snippet to commit](#the-snippet-to-commit) below.
4. Click the green <kbd>Commit changes…</kbd> button at the top-right.
5. In the dialog, choose **Create a new branch for this commit and start
   a pull request**.
   - GitHub proposes a branch name for you.
6. Click <kbd>Propose changes</kbd>.

### Step 5 — Open the pull request (inside your fork)

![on GitHub](https://img.shields.io/badge/on-GitHub-181717?style=flat-square&logo=github&logoColor=white)

GitHub now shows the *Open a pull request* page.

> [!IMPORTANT]
> Check that **base repository** points at your fork
> (**your-username/demo-java**) before clicking the green button. On some
> forks GitHub preselects the **original** repository — which would aim
> your demo PR at us instead of at your own fork. The header should read
> `base: main ← compare: <your new branch>`.

1. Confirm **base repository** is your fork, as above.
2. Click <kbd>Create pull request</kbd>.
3. GitHub shows the *Open a pull request* form — click
   <kbd>Create pull request</kbd> again.

Lost the page? In your fork, open the **Pull requests** tab, click
<kbd>New pull request</kbd>, and pick your new branch as **compare** —
both sides stay on your fork. (In a hurry? Committing straight to
`main` also works — PRGuard audits every push — but you'd miss the
PR-review half of the demo.)

### Step 6 — Watch the review land

![in PRGuard](https://img.shields.io/badge/in-PRGuard-1C8A4E?style=flat-square) ![on GitHub](https://img.shields.io/badge/on-GitHub-181717?style=flat-square&logo=github&logoColor=white)

1. Open **Audit Log** in PRGuard.
   - Your run appears under **Active pipeline runs** while it works.
2. When it completes, it moves to **Recent audits** with its verdict.
   - The demo's two findings — one error, one warning — result in a
     **FAIL** verdict.
3. Click the audit log report — it should flag the two mistakes listed
   in [What PRGuard should find](#what-prguard-should-find) below.
4. Then refresh your PR's **Conversation** tab on GitHub.
   - PRGuard posts its review there within a minute or two.

### Step 7 — Fix one finding with AI

![in PRGuard](https://img.shields.io/badge/in-PRGuard-1C8A4E?style=flat-square)

In the report, every finding carries one of two tags:

- **Human fix** means only a person can resolve it.
  - A leaked key must be *rotated*, and no tool can un-leak a secret.
- **AI fix** means it's exactly the kind of violation PRGuard can try
  to fix for you.

1. In the audit report, find the `money-formatting` finding and tick its
   checkbox in the **AI Fix** column.
2. Click <kbd>Fix selected with AI (1)</kbd>, then <kbd>Apply fixes</kbd> in
   the confirmation dialog.
3. PRGuard commits the fix straight to your pull request's branch.
   - The finding shows a **Committed ↗** link when it's done.
4. Follow that link to review the fix commit on GitHub.
   - The new commit re-audits your PR automatically, and
     `money-formatting` clears.
5. Back in the Audit Log, expand the PR's group to see how the audits
   relate.
   - **Commit** rows audit just that pushed commit — the AI fix scores
     **Pass 100** on its own.
   - **PR** rows re-audit the full cumulative diff — it stays **Fail**
     while the leaked key remains. That one's next.

### Step 8 — Fix the leaked key yourself

![on GitHub](https://img.shields.io/badge/on-GitHub-181717?style=flat-square&logo=github&logoColor=white) ![in PRGuard](https://img.shields.io/badge/in-PRGuard-1C8A4E?style=flat-square)

The `secrets` finding needs a human — PRGuard won't auto-fix a leaked
credential, because the real remedy is *rotating* the key **and**
removing it from the source code. The demo key is fabricated, so here
deleting it is the whole fix.

1. In your fork, use the <kbd>main</kbd> branch dropdown at the
   top-left of the file list to switch to your pull request's branch.
   - It's the one GitHub created for you — something like
     `your-username-patch-1`.
2. Open the file you edited previously and click the **pencil icon**.
3. Delete the payment-key line you pasted and click
   <kbd>Commit changes…</kbd>.
4. In the dialog, keep **Commit directly to the branch** selected and
   click <kbd>Commit changes</kbd>.
5. PRGuard re-audits your pull request.
6. Open the report and watch **Fix progression** climb to **PASS · 100**.
   - Every finding cleared.

### Step 9 — Merge your pull request

![on GitHub](https://img.shields.io/badge/on-GitHub-181717?style=flat-square&logo=github&logoColor=white)

Green across the board — both findings resolved and the cumulative diff
at 100. Time to merge it back into your fork.

1. In your fork, open the **Pull requests** tab and click your pull
   request.
   - Its header now shows *Ready to merge*.
2. Scroll down to **All checks have passed** and click
   <kbd>Merge pull request</kbd>.
   - That one successful check is PRGuard.
3. Click <kbd>Confirm merge</kbd>.
4. GitHub offers <kbd>Delete branch</kbd> — safe to click; the demo
   branch has done its job.
5. That's the loop closed — the full audit history stays in your
   Audit Log.

> [!TIP]
> **Deep Context.** The context file's `@ref:src/main/java/demo/Db.java` line pulls a compact
> summary of the shared data helpers into the audit. Your standards can
> reference any file in the repo, and the auditor reads that summary
> alongside your diff — even when your change never touches the file.

## The snippet to commit

Paste this inside the `OrderService` class in [`src/main/java/demo/OrderService.java`](src/main/java/demo/OrderService.java), just before the closing brace:

```java
    static final String PAYMENT_API_KEY = "sk_live_51Kx9GpLmQn24RtUvWx8YzAbCdEfGh36";

    /** Return a one-line receipt for {@code order}. */
    public String formatReceipt(Order order) {
        return "Order " + order.id() + ": $" + (order.totalCents() / 100.0);
    }
```

> [!NOTE]
> The `sk_live_…` key is fabricated for this demo — it unlocks nothing and
> is safe to commit to your fork. PRGuard doesn't know that, and that's the
> point. If your fork has GitHub secret scanning enabled (off by default on
> forks), it will flag this key too — that's expected, and proof the plant
> is realistic; dismiss that alert as *used in tests*.

## What PRGuard should find

| Finding | Review type | The fix |
| ------- | :---------: | ------- |
| 🔑 A live payment key hardcoded in `OrderService.java` | **Human** | Rotate the key with the payment provider, then load it from an environment variable. A committed key is a compromised key — moving it is not enough, and no AI can un-leak a secret. |
| 💸 Currency built by hand in `OrderService.java` (`totalCents() / 100.0`) | **AI** | *Fix with AI* swaps the hand-rolled string for the shared `Db.money()` helper in `Db.java` — the same helper Deep Context placed in front of the auditor. Double division drops trailing zeros (`1200` → `$12.0`); `money()` formats cents exactly. |

Nothing else is wrong on purpose, so the report stays short and the two
findings stand out — a leaked secret only **you** can resolve, and a
formatting violation **PRGuard** offers to fix for you with AI.

> [!TIP]
> **"GitHub flags the key too — so why PRGuard?"** It does, and that's half
> the point: two independent systems agreeing means the audit isn't guessing.
> But secret scanning matches known provider patterns after the key is
> already in your history — it can't apply your policy, and it will never
> see the currency bug. PRGuard reads the change like a reviewer: it flags
> the exact line the moment you push, applies this repo's standards (a
> committed key is *rotated*, not relocated), and offers the fix.

---

<div align="center">

<a href="https://prguard.dev">
  <img src=".github/prguard-logo.svg" alt="PRGuard" width="36" height="36">
</a>

**Govern your codebase. Auto-fix the violations.**

[prguard.dev](https://prguard.dev) · MIT © 2026 Unifi Software Development Ltd

</div>
