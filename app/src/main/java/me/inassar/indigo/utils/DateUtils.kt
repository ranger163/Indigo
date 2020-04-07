package me.inassar.indigo.utils

import android.annotation.SuppressLint
import android.text.format.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private const val TAG = "DateUtils"
    const val DATE_FORMAT_1 = "hh:mm a"
    const val DATE_FORMAT_2 = "h:mm a"
    const val DATE_FORMAT_3 = "yyyy MM dd"
    const val DATE_FORMAT_4 = "dd-MMMM-yyyy"
    const val DATE_FORMAT_5 = "dd MMMM yyyy"
    const val DATE_FORMAT_6 = "dd MMMM yyyy zzzz"
    const val DATE_FORMAT_7 = "EEE, MMM d, ''yy"
    const val DATE_FORMAT_8 = "yyyy-MM-dd HH:mm:ss"
    const val DATE_FORMAT_9 = "h:mm a dd MMMM yyyy"
    const val DATE_FORMAT_10 = "K:mm a, z"
    const val DATE_FORMAT_11 = "hh 'o''clock' a, zzzz"
    const val DATE_FORMAT_12 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val DATE_FORMAT_13 = "E, dd MMM yyyy HH:mm:ss z"
    const val DATE_FORMAT_14 = "yyyy.MM.dd G 'at' HH:mm:ss z"
    const val DATE_FORMAT_15 = "yyyyy.MMMMM.dd GGG hh:mm aaa"
    const val DATE_FORMAT_16 = "EEE, d MMM yyyy HH:mm:ss Z"
    const val DATE_FORMAT_17 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
    const val DATE_FORMAT_18 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"

    val arabicDate: String
        get() {
            val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()
            val month = convertMonth(
                Calendar.getInstance().get(Calendar.MONTH).plus(1)
            )
            val year = Calendar.getInstance().get(Calendar.YEAR).toString()
            return "$day $month $year"
        }

    val currentDate: String
        @SuppressLint("SimpleDateFormat")
        get() {
            val dateFormat =
                SimpleDateFormat(DATE_FORMAT_3)
            dateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val today = Calendar.getInstance().time
            return dateFormat.format(today)
        }

    val currentTime: String
        @SuppressLint("SimpleDateFormat")
        get() {
            val dateFormat =
                SimpleDateFormat(DATE_FORMAT_1)
            dateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val today = Calendar.getInstance().time
            return dateFormat.format(today)
        }

    /**
     * @param time        in milliseconds (Timestamp)
     * @param mDateFormat SimpleDateFormat
     */
    @SuppressLint("SimpleDateFormat")
    fun getDateTimeFromTimeStamp(time: Long?, mDateFormat: String?): String {
        val dateFormat = SimpleDateFormat(mDateFormat!!)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val dateTime = Date(time!!)
        return dateFormat.format(dateTime)
    }

    /**
     * Get Timestamp from date and time
     *
     * @param mDateTime   datetime String
     * @param mDateFormat Date Format
     * @throws ParseException
     */
    @SuppressLint("SimpleDateFormat")
    @Throws(ParseException::class)
    fun getTimeStampFromDateTime(
        mDateTime: String?,
        mDateFormat: String?
    ): Long {
        val dateFormat = SimpleDateFormat(mDateFormat!!)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = dateFormat.parse(mDateTime!!)
        return date!!.time
    }

    /**
     * Return  datetime String from date object
     *
     * @param mDateFormat format of date
     * @param date        date object that you want to parse
     */
    fun formatDateTimeFromDate(mDateFormat: String?, date: Date?): String? {
        return if (date == null) {
            null
        } else DateFormat.format(mDateFormat, date).toString()
    }

    /**
     * Convert one date format string  to another date format string in android
     *
     * @param inputDateFormat  Input SimpleDateFormat
     * @param outputDateFormat Output SimpleDateFormat
     * @param inputDate        input Date String
     * @throws ParseException
     */
    @Throws(ParseException::class)
    fun formatDateFromDateString(
        inputDateFormat: String?, outputDateFormat: String?,
        inputDate: String?
    ): String {
        val mParsedDate: Date
        val mOutputDateString: String
        val mInputDateFormat =
            SimpleDateFormat(inputDateFormat!!, Locale.getDefault())
        val mOutputDateFormat =
            SimpleDateFormat(outputDateFormat!!, Locale.getDefault())
        mParsedDate = mInputDateFormat.parse(inputDate!!)!!
        mOutputDateString = mOutputDateFormat.format(mParsedDate)
        return mOutputDateString
    }

    /**
     * Convert month from numbers to Arabic gregorian
     * @param month
     * @return String
     * */
    private fun convertMonth(month: Int): String {
        return when (month) {
            1 -> "يناير"
            2 -> "فبراير"
            3 -> "مارس"
            4 -> "أبريل"
            5 -> "مايو"
            6 -> "يونيو"
            7 -> "يوليو"
            8 -> "أغسطس"
            9 -> "سبتمبر"
            10 -> "أكتوبر"
            11 -> "نوفمبر"
            else -> "ديسمبر"
        }
    }
}