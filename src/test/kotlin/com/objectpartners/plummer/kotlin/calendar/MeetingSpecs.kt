package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.Meeting
import org.jetbrains.spek.api.Spek
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MeetingSpecs: Spek() {
    init {
        given("New Meeting") {
            val meeting = Meeting()
            on("getting the identifier") {
                it("should be populated") {
                    assertTrue(meeting.id.isNotBlank())
                }
            }
            on("getting the attendees") {
                it("should be non-null and empty") {
                    assertTrue(meeting.attendees.isEmpty())
                }
            }
            on("adding an attendee") {
                it("should successfully add") {
                    meeting.attendees += "ATTENDEE"
                    assertEquals(meeting.attendees.size, 1)
                }
                it("should retain the same reference") {
                    val originalAttendees = meeting.attendees
                    meeting.attendees += "ATTENDEE 2"
                    assertTrue(originalAttendees === meeting.attendees)
                }
                it("should not allow duplicates") {
                    meeting.attendees.clear()
                    meeting.attendees += "ATTENDEE"
                    meeting.attendees += "ATTENDEE"
                    assertEquals(meeting.attendees.size, 1)
                }
            }
        }
    }
}
